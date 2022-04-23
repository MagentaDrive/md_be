package magentadrive.storage_service.DocumentService.repos;


import magentadrive.storage_service.DocumentService.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repository
 */
@Repository
public interface DocumentRepo extends JpaRepository<Document, UUID> {
    List<Document> findAllByUserId(UUID id);


}
