package magentadrive.post_service.service;

import magentadrive.post_service.model.Tag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface TagService {

    void createTagToPost(Tag t);

    Tag getTag(String name);

    List<Tag> getTagFromPost(UUID postId);

}
