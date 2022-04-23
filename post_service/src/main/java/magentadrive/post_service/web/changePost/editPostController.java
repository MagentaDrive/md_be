package magentadrive.post_service.web.changePost;


import magentadrive.post_service.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/posts")
@RestController
public class editPostController {

    private final PostService service;

    public editPostController(PostService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody editPostRequest request, @PathVariable String id) {
        var post = service.getPost(request.getPostId());
        var newTitle = request.getTitle();
        var newTextContent = request.getTextContent();
        post.setTitle(newTitle);
        post.setTextContent(newTextContent);
        try {
            service.createPost(post);
            return ResponseEntity.ok(new editPostResponse("Erfolgreich Bearbeitet"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }


    }

}
