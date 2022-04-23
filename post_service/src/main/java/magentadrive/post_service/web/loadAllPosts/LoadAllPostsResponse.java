package magentadrive.post_service.web.loadAllPosts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import magentadrive.post_service.model.Post;
import org.springframework.data.domain.Page;

@AllArgsConstructor
public class LoadAllPostsResponse {

    @Getter
    @Setter
    public Page<Post> posts;
}
