package magentadrive.post_service.web.createTag;

import magentadrive.post_service.model.Tag;
import magentadrive.post_service.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/posts")
@RestController
public class createTagController {

    private final TagService service;

    public createTagController(TagService service) {
        this.service = service;
    }

    @PostMapping("/{id}/tag")
    public ResponseEntity<?> createTag(@RequestBody createTagRequest request) {
        try {
            var a = new Tag(
                    request.getName()
            );
            service.createTagToPost(a);
            return ResponseEntity.ok().body(new createTagResponse(a.getName()));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}


