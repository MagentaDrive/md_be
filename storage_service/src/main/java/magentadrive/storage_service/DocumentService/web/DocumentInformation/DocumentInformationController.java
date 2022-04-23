package magentadrive.storage_service.DocumentService.web.DocumentInformation;


import magentadrive.storage_service.DocumentService.services.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controller to get all information about the file
 */
@RequestMapping("/storage")
@RestController
public class DocumentInformationController {

    private final FileService fileService;

    public DocumentInformationController(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * Get
     *
     * @param request GetFileRequest
     * @return if ok ResponseEntity of type GetFileResponse
     */
    @GetMapping("/files/{id}/info")
    public ResponseEntity<?> getDocInformation(@RequestBody DocumentInformationRequest request) {
        var id = request.getId();
        var file = fileService.getDocByID(id);
        if (file != null) {

            return ResponseEntity.ok(
                    new DocumentInformationResponse(
                            file.getTitle(),
                            file.getFiletype(),
                            file.getUploadDate(),
                            file.getUserId(),
                            file.getBucket(),
                            file.getObjectName(),
                            file.getUniversityId(),
                            file.getPostId()
                    ));
        } else {
            return ResponseEntity.internalServerError().body("Es konnte keine File gefunden werden ");
        }
    }

}
