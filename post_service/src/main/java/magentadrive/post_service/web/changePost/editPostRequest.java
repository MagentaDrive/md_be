package magentadrive.post_service.web.changePost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
public class editPostRequest {
    @Getter
    @Setter
    private UUID postId;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String textContent;
}
