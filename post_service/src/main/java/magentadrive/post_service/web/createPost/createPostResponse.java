package magentadrive.post_service.web.createPost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@AllArgsConstructor
public class createPostResponse {

    @Getter
    @Setter
    private UUID postId;
}
