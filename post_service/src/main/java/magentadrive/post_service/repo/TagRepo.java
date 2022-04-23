package magentadrive.post_service.repo;

import magentadrive.post_service.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TagRepo extends JpaRepository<Tag, String> {

    //@Query(value = "SELECT tag_name FROM post_tag WHERE post_id = ?1" )
    //List<Tag> getTagsFromPost(UUID postId);
}
