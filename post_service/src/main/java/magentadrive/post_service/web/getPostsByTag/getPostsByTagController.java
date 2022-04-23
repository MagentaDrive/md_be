package magentadrive.post_service.web.getPostsByTag;

import magentadrive.post_service.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/posts")
@RestController
public class getPostsByTagController {

    @Autowired
    private final PostService service;

    public getPostsByTagController(PostService service) {
        this.service = service;
    }
    @GetMapping("")
    public ResponseEntity<?> getPostsByTag(@RequestBody getPostsByTagRequest request){
        var allPosts = service.getPostsByTag(request.getTagName());

        return ResponseEntity.ok(new getPostsByTagResponse(
                allPosts
        ));
    }
}
