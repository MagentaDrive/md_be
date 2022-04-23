package magentadrive.post_service.web.addCommentToPost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
public class AddCommentToPostResponse {

    @Getter
    @Setter
    public UUID commentId;
}
