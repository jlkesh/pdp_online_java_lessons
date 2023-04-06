# Example Code

## Comment

````java

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer postId;
    private String name;
    private String email;
    private String body;
}
````
 

````java

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentRepository commentRepository;

    public CommentController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable Integer id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment Not Found With ID: " + id));
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/")
    public ResponseEntity<List<Comment>> getAllComment() {
        List<Comment> comments = commentRepository.findAll();
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Integer id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment Not Found With ID: " + id));
        commentRepository.delete(comment);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(commentRepository.save(comment));
    }
}
````

## Post

````java

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}
````

````java

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        Post comment = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post Not Found With ID: " + id));
        return ResponseEntity.ok(comment);
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPost() {
        List<Post> comments = postRepository.findAll();
        return ResponseEntity.ok(comments);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        Post comment = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post Not Found With ID: " + id));
        postRepository.delete(comment);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Post> savePost(@RequestBody Post comment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(comment));
    }
}
````

## Todo

````java

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {
    private Integer id;
    private Integer userId;
    private String title;
    private boolean completed;
}
````

````java

@RestController
@RequestMapping("/api/todo")
public class PostController {
    private final TodoRepository todoRepository;

    public PostController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Integer id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo Not Found With ID: " + id));
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodo() {
        List<Todo> todos = todoRepository.findAll();
        return ResponseEntity.ok(todos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Integer id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Todo Not Found With ID: " + id));
        todoRepository.delete(todo);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<Todo> saveTodo(@RequestBody Todo todo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoRepository.save(todo));
    }
}
````

````
https://jsonplaceholder.typicode.com/todos
````

````
https://jsonplaceholder.typicode.com/posts
````

````
https://jsonplaceholder.typicode.com/comments
````

# OpenAPI Configuration with Annotation Config

````java
@OpenAPIDefinition(
        info = @Info(
                title = "Spring 6 Swagger With Annotation Config",
                version = "${api.version}",
                contact = @Contact(
                        name = "Elmurodov Javohir", email = "john.lgd65@gmail.com", url = "https://github.com/jlkesh"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://springdoc.org"),
                termsOfService = "http://swagger.io/terms/",
                description = "Spring 6 Swagger Simple Application"
        ),
        externalDocs = @ExternalDocumentation(
                description = "Spring 6 Wiki Documentation", url = "https://springshop.wiki.github.org/docs"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Production-Server"
                ),
                @Server(
                        url = "http://localhost:9090",
                        description = "Test-Server"
                )
        }
)
````

# OpenAPI Configuration with Java Config

````java

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring 6 Swagger 2 Annotation Example")
                        .description("Spring 6 Swagger Simple Application")
                        .version("${api.version}")
                        .contact(new Contact()
                                .name("Elmurodov Javohir")
                                .email("john.lgd65@gmail.com")
                                .url("https://github.com/jlkesh"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .termsOfService("http://swagger.io/terms/"))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"))
                .servers(List.of(
                        new Server()
                                .url("http://localhost:8080")
                                .description("Production")
                ));
    }
}
````

# Annotations

* `@Tag`
* `@Parameter`
* `@Hidden`
* `@Schema`
* `@Operation`
* `@ApiResponse`

````java
@Operation(summary = "Create New Store", description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = RuntimeException.class))
        })
})
````

<details>
<summary style="font-size:40px; font-weight:bold;">Security Config</summary>

# Security Support (JWT Bearer) With Java Config

````java
...
        .components(new Components()
        .addSecuritySchemes("bearerAuth",new SecurityScheme()
        .name("bearerAuth")
        .type(SecurityScheme.Type.HTTP)
        .scheme("bearer")
        .bearerFormat("JWT")));
        ... 
````

# Security Support (HTTP Basic) With Java Config

````java
...
        .components(new Components()
        .addSecuritySchemes("basicAuth",new SecurityScheme()
        .name("basicAuth")
        .type(SecurityScheme.Type.HTTP)
        .scheme("basic")));
        ... 
````

# Security Support (JWT Bearer) With Annotation

````java
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
````

# Security Support (HTTP Basic) With Annotation

````java
@SecurityScheme(
        name = "basicAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "basic"
)
````

</details>

## Grouping

````java
class Config {
    @Bean
    public GroupedOpenApi annotationGroupAPI() {
        return GroupedOpenApi.builder()
                .group("annotation")
                .pathsToMatch("/store/**", "/config/**")
                .build();
    }
}
````

## Cors

````java
class Config {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }
}
````