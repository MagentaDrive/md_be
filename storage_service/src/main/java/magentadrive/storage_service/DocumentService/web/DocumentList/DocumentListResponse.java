package magentadrive.storage_service.DocumentService.web.DocumentList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import magentadrive.storage_service.DocumentService.model.Document;

import java.util.List;


/**
 * Response from GetFileList Controller. Returns a List of Files
 */
@AllArgsConstructor
public class DocumentListResponse {

    @Getter
    @Setter
    List<Document> fileList;
}
