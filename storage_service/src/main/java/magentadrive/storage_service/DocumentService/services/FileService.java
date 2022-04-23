package magentadrive.storage_service.DocumentService.services;


import magentadrive.storage_service.DocumentService.model.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;
import java.util.UUID;


public interface FileService {


    List<Document> getAllDocsFromUser(UUID ID);

    List<Document> getDocumentByContainingString(String s);

    Document getDocByID(UUID id);

    List<Document> getAllDocs();

    boolean bucketExists(String bucketName);

    void makeBucket(String bucketName);

    String putObject(MultipartFile file, String bucketName, String fileType, UUID uploader, UUID postId, int universityId, int courseId);

    InputStream downloadObject(String bucketName, String objectName);

    void saveDocData(Document f);


}
