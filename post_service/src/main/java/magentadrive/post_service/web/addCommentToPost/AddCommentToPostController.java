package magentadrive.post_service.web.addCommentToPost;


import magentadrive.post_service.model.Comment;
import magentadrive.post_service.service.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("/posts")

public class AddCommentToPostController {

    private final CommentService commentService;

    public AddCommentToPostController(CommentService commentService) {this.commentService = commentService;}

    @PostMapping("/{id}/comment")
    public ResponseEntity<?> addCommentToPost(@RequestBody AddCommentToPostRequest request) {

        var c = new Comment(
                request.getUserId(),
                request.getTitle(),
                request.getPostId(),
                request.getTextContent(),
                LocalDateTime.now()
        );

        try {
            commentService.addCommentToPost(c);
            return ResponseEntity.ok(new AddCommentToPostResponse(
                    c.getCommentId()
            ));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }


    }

}
