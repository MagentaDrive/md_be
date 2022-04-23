package magentadrive.post_service.web.getPostsByTag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import magentadrive.post_service.model.Post;

import java.util.List;

@AllArgsConstructor
public class getPostsByTagResponse {

    @Getter
    @Setter
    public List<Post> posts;
}
