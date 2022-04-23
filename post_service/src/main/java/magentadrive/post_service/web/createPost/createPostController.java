package magentadrive.post_service.web.createPost;

import magentadrive.post_service.model.Post;
import magentadrive.post_service.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/post")
@RestController
public class createPostController {
    private final PostService service;

    public createPostController(PostService service) {
        this.service = service;
    }

    @PostMapping("")
    public ResponseEntity<?> createPost(@RequestBody createPostRequest request) {
        try {
            var a = new Post(
                    request.getTitle(),
                    request.getUserId(),
                    request.getDocumentId(),
                    LocalDateTime.now(),
                    request.getHochschuleId(),
                    request.getStudiengangId(),
                    request.getTextContent(),
                    request.getStatus()
            );
            service.createPost(a);
            return ResponseEntity.ok().body(new createPostResponse(a.getPostId()));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
