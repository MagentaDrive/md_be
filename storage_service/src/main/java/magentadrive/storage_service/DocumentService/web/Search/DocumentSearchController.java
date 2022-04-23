package magentadrive.storage_service.DocumentService.web.Search;


import magentadrive.storage_service.DocumentService.services.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller search Docs
 */
@RequestMapping("/storage")
@RestController
public class DocumentSearchController {

    private final FileService fileService;

    public DocumentSearchController(FileService fileService) {this.fileService = fileService;}

    @GetMapping(value = "/search")
    public ResponseEntity<?> searchDocument(@RequestBody DocumentSearchRequest request) {
        var searchString = request.getSearchString();

        var docList = fileService.getDocumentByContainingString(searchString);
        return ResponseEntity.ok().body(
                new DocumentSearchResponse(
                        docList
                ));

    }
}
