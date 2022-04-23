package magentadrive.storage_service.DocumentService.web.DocumentDownload;


import magentadrive.storage_service.DocumentService.services.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;

/**
 * Controller to download a file
 */
@RequestMapping("/storage")
@RestController
public class DocumentDownloadController {

    private final FileService fileService;


    public DocumentDownloadController(FileService fileService) {
        this.fileService = fileService;
    }

    /**
     * Get
     *
     * @param request DownloadRequest
     * @return a Message
     */
    @GetMapping("/files/{Id}")
    public ResponseEntity<DocumentDownloadResponse> downloadDoc(@Valid @RequestBody DocumentDownloadRequest request) {
        var file = fileService.getDocByID(request.getId());
        var bucketName = file.getBucket();
        var objectName = file.getObjectName();
        InputStream in = null;

        try {
            in = fileService.downloadObject(bucketName, objectName);
            return ResponseEntity.ok(new DocumentDownloadResponse("Download erfolgt"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(new DocumentDownloadResponse("Fehler beim Download"));
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
