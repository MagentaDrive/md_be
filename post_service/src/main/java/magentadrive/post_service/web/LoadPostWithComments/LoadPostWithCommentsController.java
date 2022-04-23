package magentadrive.post_service.web.LoadPostWithComments;

import magentadrive.post_service.service.CommentService;
import magentadrive.post_service.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/posts")
@RestController
public class LoadPostWithCommentsController {

    private final PostService postService;
    private final CommentService commentService;

    public LoadPostWithCommentsController(PostService postService, CommentService commentService) {
        this.postService = postService;
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> loadPostWithComments(@RequestBody LoadPostWithCommentsRequest request) {
        var postId = request.getPostId();
        var post = postService.getPost(postId);
        var comments = commentService.getCommentsFromPost(postId);
        return ResponseEntity.ok(new LoadPostWithCommentsResponse(
                post,
                comments
        ));
    }
}
