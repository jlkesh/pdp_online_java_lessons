# Comments-Service

[Yuklab Olish](./hateoas-api-service.jar)

````shell
java -jar hateoas-api-service.jar
````

[http://localhost:9595/swagger-ui.html](http://localhost:9595/swagger-ui.html)

# Yoki

````java

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
````

````java
public interface PostRepository extends JpaRepository<Post, Integer> {}
````

````java
@Component
public class PostModelAssembler implements RepresentationModelAssembler<Post, EntityModel<Post>> {
    @Override
    public EntityModel<Post> toModel(Post post) {
        Link selfRelation = linkTo(methodOn(PostController.class).getPost(post.getId())).withSelfRel();
        Link postsRelation = linkTo(methodOn(PostController.class).getPosts()).withRel("posts");
        return EntityModel.of(post, selfRelation, postsRelation);
    }

    @Override
    public CollectionModel<EntityModel<Post>> toCollectionModel(Iterable<? extends Post> entities) {
        List<EntityModel<Post>> entityModels = new ArrayList<>();
        entities.forEach(post -> entityModels.add(toModel(post)));
        Link postsRelation = linkTo(methodOn(PostController.class).getPosts()).withRel("posts");
        return CollectionModel.of(entityModels, postsRelation);
    }
}
````

````java
@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;
    private final PostModelAssembler postModelAssembler;
    private final PagedResourcesAssembler<Post> pagedResourcesAssembler;

    PostController(PostRepository postRepository,
                   PostModelAssembler postModelAssembler,
                   @Qualifier("postPagedResourcesAssembler") PagedResourcesAssembler<Post> pagedResourcesAssembler) {
        this.postRepository = postRepository;
        this.postModelAssembler = postModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }


    @GetMapping("/")
    public CollectionModel<EntityModel<Post>> getPosts() {
        List<Post> posts = postRepository.findAll();
        return postModelAssembler.toCollectionModel(posts);
    }

    @GetMapping("/paged")
    public PagedModel<EntityModel<Post>> getPage(@RequestParam(required = false, defaultValue = "10") int size,
                                                 @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = postRepository.findAll(pageable);
        return pagedResourcesAssembler.toModel(posts, postModelAssembler);
    }

    @GetMapping("/{id}")
    public EntityModel<Post> getPost(@PathVariable Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return postModelAssembler.toModel(post);
    }

}
````

````java

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ObjectMapper objectMapper, PostRepository postRepository) {
        return (args -> {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            List<Post> posts = objectMapper.readValue(url, new TypeReference<List<Post>>() {
            });
            postRepository.saveAll(posts);
        });
    }
    
    @Bean(name = "postPagedResourcesAssembler")
    public PagedResourcesAssembler<Post> postPagedResourcesAssembler() {
        return new PagedResourcesAssembler<>(new HateoasPageableHandlerMethodArgumentResolver(), null);
    }
}
````

