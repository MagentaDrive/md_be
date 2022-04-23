package magentadrive.post_service.service;

import magentadrive.post_service.model.Tag;
import magentadrive.post_service.repo.TagRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@ComponentScan
@Service
public class TagServiceImpl implements TagService{

    @Autowired
    private TagRepo repo;

    @Override
    public void createTagToPost(Tag t) {repo.save(t);}

    @Override
    public Tag getTag(String name) {
        return repo.getById(name);
    }

    @Override
    public List<Tag> getTagFromPost(UUID postId) {
        //return repo.getTagsFromPost(postId);
        return null;
        //TODO
    }


}
