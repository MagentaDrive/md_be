package magentadrive.post_service.web.loadAllPosts;

import magentadrive.post_service.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@RequestMapping("/posts")
@RestController
public class LoadAllPostsController {
    private final PostService service;

    public LoadAllPostsController(PostService service) {
        this.service = service;
    }

    @GetMapping("?size={size}")
    public ResponseEntity<?> loadAllPosts(@RequestBody LoadAllPostsRequest request, @RequestParam("size") int s) {
        var allPosts = service.getAllPosts(s);

        return ResponseEntity.ok(new LoadAllPostsResponse(
            allPosts
        ));
    }
}