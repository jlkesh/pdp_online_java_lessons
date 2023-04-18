# Comments-Service

[Yuklab Olish](./comments-service.jar)

````shell
java -jar comments-service.jar
````

[http://localhost:9595/swagger-ui.html](http://localhost:9595/swagger-ui.html)

# Yoki

````java

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    private Integer postId;

    public Comment(CommentCreateDTO commentCreateDTO) {
        this.message = commentCreateDTO.getMessage();
        this.postId = commentCreateDTO.getPostId();
    }
}
````

````java

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateDTO {
    private String message;
    private Integer postId;
}
````

````java
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("select c from Comment c where c.postId = ?1")
    List<Comment> findAllByPostId(Integer postId);
}
````

````java
@Slf4j
@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;

    @GetMapping
    public ResponseEntity<List<Comment>> getAll() {
        return ResponseEntity.ok(commentRepository.findAll());
    }

    @GetMapping("/{id}/post")
    public ResponseEntity<List<Comment>> getAllByPostId(@PathVariable Integer id) throws InterruptedException {
        log.info("Comments requested for POST ID : {}", id);
        TimeUnit.SECONDS.sleep(1L);
        return ResponseEntity.ok(commentRepository.findAllByPostId(id));
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Void> createList(@RequestBody List<CommentCreateDTO> dtos) {
        log.info("Creating List Of Comments : {}", dtos);
        List<Comment> comments = dtos.stream()
                .map(Comment::new)
                .toList();
        commentRepository.saveAll(comments);
        return ResponseEntity.ok(null);
    }
}
````

