package magentadrive.post_service.web.addCommentToPost;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class AddCommentToPostRequest {

    @Getter
    @Setter
    private int userId;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private int postId;

    @Getter
    @Setter
    private String textContent;

    @Getter
    @Setter
    private LocalDateTime date;


}
