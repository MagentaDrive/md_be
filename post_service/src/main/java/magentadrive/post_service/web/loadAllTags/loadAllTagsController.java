package magentadrive.post_service.web.loadAllTags;

import magentadrive.post_service.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/posts")
@RestController
public class loadAllTagsController {

    private final TagService service;

    public loadAllTagsController(TagService service) {
        this.service = service;
    }
    @GetMapping("/{id}/tag")
    public ResponseEntity<?> loadAllTags(@RequestBody loadAllTagsRequest request) {
        var postId = request.getPostId();
        var allTags = service.getTagFromPost(postId);

        return ResponseEntity.ok(new loadAllTagsResponse(
                allTags
        ));
    }
}
