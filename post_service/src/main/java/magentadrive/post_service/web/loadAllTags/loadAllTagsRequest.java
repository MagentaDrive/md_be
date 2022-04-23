package magentadrive.post_service.web.loadAllTags;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class loadAllTagsRequest {
    @Setter
    @Getter
    private UUID postId;

}
