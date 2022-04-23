package magentadrive.storage_service.DocumentService.web.DocumentInformation;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Response from GetFileController. Returns the Information about the File
 * the name of the File,
 * the uploader name,
 * Count of likes,
 * datetime of uploud,
 * bucket name for minio
 * and the object name in minio
 */
@AllArgsConstructor
public class DocumentInformationResponse {

    private String title;
    private String type;


    private LocalDateTime dateTime;

    private UUID uploader;


    private String bucket;

    private String objectName;

    private long UniversityID;

    private UUID postId;


}
