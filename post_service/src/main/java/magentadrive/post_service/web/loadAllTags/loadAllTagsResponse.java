package magentadrive.post_service.web.loadAllTags;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import magentadrive.post_service.model.Tag;

import java.util.List;

@AllArgsConstructor
public class loadAllTagsResponse {
    @Getter
    @Setter
    public List<Tag> tags;
}
