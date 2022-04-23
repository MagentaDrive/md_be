package magentadrive.post_service.web.changeTag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class changeTagRequest {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String newName;
}
