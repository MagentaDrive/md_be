package magentadrive.post_service.service;

import magentadrive.post_service.model.Post;
import magentadrive.post_service.model.Tag;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface PostService {

    UUID createPost(Post p);

    void changePost(Post p);

    List<Post> getPostsByTag(String name);

    Post getPost(UUID postId);

    Page<Post> getAllPosts(int size);

}
