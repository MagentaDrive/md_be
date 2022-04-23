package magentadrive.post_service.repo;

import magentadrive.post_service.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostRepo extends JpaRepository<Post, UUID> {

   // @Query(value = "SELECT post_id FROM post_tag WHERE tag_name = ?1")
    //List<Post> getPostsByTag(String name);


}
