package magentadrive.storage_service.DocumentService.web.DocumentList;

import magentadrive.storage_service.DocumentService.services.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Controller to get All Files
 */

@RequestMapping("/storage")
@RestController
public class DocumentListController {
    private final FileService fileService;

    public DocumentListController(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * get
     *

     * @return if ok ResponsEntity of type getFileListResponse
     */
    @CrossOrigin(origins = "*")
    @GetMapping("/files")
    public ResponseEntity<?> getAllDocs() {
        var files = fileService.getAllDocs();
        if (files == null) {
            return ResponseEntity.internalServerError().body("Fehler beim Laden der Files");
        } else
            return ResponseEntity.ok(
                    new DocumentListResponse(
                            files
                    ));
    }
}
