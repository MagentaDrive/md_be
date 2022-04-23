package magentadrive.storage_service.DocumentService.web.DocumentUpload;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * Request to the MinioMultipartFileUploadController
 */
public class DocumentUploadRequest {

    @Getter
    private MultipartFile file;

    @Getter
    private String bucketName;

    @Getter
    private UUID uploaderId;

    @Getter
    private UUID postID;

    @Getter
    private int universityId;

    @Getter
    private int courseId;


}
