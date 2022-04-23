package magentadrive.storage_service.DocumentService.web.Search;

import lombok.AllArgsConstructor;
import magentadrive.storage_service.DocumentService.model.Document;

import java.util.List;

@AllArgsConstructor
public class DocumentSearchResponse {
    List<Document> docs;
}
