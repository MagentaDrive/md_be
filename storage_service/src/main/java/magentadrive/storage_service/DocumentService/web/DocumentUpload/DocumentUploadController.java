package magentadrive.storage_service.DocumentService.web.DocumentUpload;

import magentadrive.storage_service.DocumentService.services.FileService;
import magentadrive.storage_service.DocumentService.util.FileTypeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller to upload files
 */
@CrossOrigin()
@RequestMapping("/storage")
@RestController
public class DocumentUploadController {

    private final FileService fileService;
    private final long maxsizeFile = 20971520;

    public DocumentUploadController(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * Post
     *
     * @param request UploudRequest
     * @return MessageResponse if ok or bad request
     */
    @PostMapping(value = "/files")
    public ResponseEntity<DocumentUploadResponse> uploadDoc(@Valid @RequestBody DocumentUploadRequest request) {
        var file = request.getFile();

        if (file.getSize() > maxsizeFile) {
            ResponseEntity.badRequest().body(new DocumentUploadResponse("Datei zu groß, maximale Dateigröße ist 20 MB "));
        }

        String fileType = FileTypeUtils.getFileType(request.getFile());
        if (fileType != null) {
            return ResponseEntity.ok().body(
                    new DocumentUploadResponse(
                            fileService.putObject
                                    (file,
                                            request.getBucketName(),
                                            fileType,
                                            request.getUploaderId(),
                                            request.getPostID(),
                                            request.getUniversityId(),
                                            request.getCourseId()

                                    )));
        }
        return ResponseEntity.badRequest().body(new DocumentUploadResponse(" Unsupported file format . Please confirm the format , Upload again "));

    }
}
