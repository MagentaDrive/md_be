package magentadrive.post_service.web.changeTag;


import magentadrive.post_service.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/post")
@RestController
public class changeTagController {

    private final TagService service;

    public changeTagController(TagService service) {this.service=service;}

    @PostMapping("/{id}/tag/{name}")
    public ResponseEntity<?> changeTag(@RequestBody changeTagRequest request) {
        var tag = service.getTag(request.getName());
        var newName = request.getNewName();
        tag.setName(newName);
        try {
            service.createTagToPost(tag);
            return ResponseEntity.ok(new changeTagResponse("Tag erfolgreich Bearbeitet"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e);
        }
    }
}
