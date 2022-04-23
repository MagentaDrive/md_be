package magentadrive.post_service.service;

import magentadrive.post_service.model.Post;
import magentadrive.post_service.model.Tag;
import magentadrive.post_service.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepo repo;

    @Override
    public UUID createPost(Post p) {
        repo.save(p);
        return p.getPostId();
    }

    @Override
    public void changePost(Post p) {repo.save(p);}

    @Override
    public List<Post> getPostsByTag(String name) {
       // return repo.getPostsByTag(name);
        return null; //todo
    }

    @Override
    public Post getPost(UUID postId) {return repo.getById(postId);
    }

    @Override
    public Page<Post> getAllPosts(int size) {
        var posts = repo.findAll(Pageable.ofSize(size));
        return posts;
    }
}
