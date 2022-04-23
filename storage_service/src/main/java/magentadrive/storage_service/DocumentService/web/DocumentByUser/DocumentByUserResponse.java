package magentadrive.storage_service.DocumentService.web.DocumentByUser;

import lombok.AllArgsConstructor;
import magentadrive.storage_service.DocumentService.model.Document;

import java.util.List;

@AllArgsConstructor
public class DocumentByUserResponse {
    List<Document> docs;
}
