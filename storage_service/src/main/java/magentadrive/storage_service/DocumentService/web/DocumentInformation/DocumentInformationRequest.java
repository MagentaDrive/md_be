package magentadrive.storage_service.DocumentService.web.DocumentInformation;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * Request to the GetFileController
 */
public class DocumentInformationRequest {
    @Getter
    @Setter
    public UUID id;
}
