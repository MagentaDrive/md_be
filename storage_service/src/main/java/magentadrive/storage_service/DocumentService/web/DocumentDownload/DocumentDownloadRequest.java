package magentadrive.storage_service.DocumentService.web.DocumentDownload;


import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Request to the DownloadController
 */
public class DocumentDownloadRequest {

    @Getter
    @Setter
    public UUID id;
}
