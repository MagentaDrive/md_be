package magentadrive.storage_service.DocumentService.services;

import io.minio.*;
import lombok.SneakyThrows;
import magentadrive.storage_service.DocumentService.config.MinioConfig;
import magentadrive.storage_service.DocumentService.model.Document;
import magentadrive.storage_service.DocumentService.repos.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Application logik, implements the FileService
 */
@Service
public class FileServiceImpl implements FileService {

    private final MinioClient minioClient;
    private final MinioConfig minioConfig;

    @Autowired
    private DocumentRepo fileRepo;

    /**
     * Constructor
     *
     * @param minioClient Client
     * @param minioConfig Configuration
     */
    public FileServiceImpl(MinioClient minioClient, MinioConfig minioConfig) {
        this.minioClient = minioClient;
        this.minioConfig = minioConfig;
    }

    /**
     * Saving Data
     *
     * @param f the file
     */
    @Override
    public void saveDocData(Document f) {
        fileRepo.save(f);
    }


    @Override
    public List<Document> getAllDocsFromUser(UUID Id) {
        var docs =  fileRepo.findAll();
       return docs.stream().filter(doc -> doc.getUserId() == (Id)).collect(Collectors.toList());

       // return fileRepo.findAllByUserId(Id);
    }

    @Override
    public List<Document> getDocumentByContainingString(String s) {
       var docs =  fileRepo.findAll();

        return docs.stream()
                .filter( d -> d.getTitle().contains(s)).collect(Collectors.toList());

    }

    /**
     * Returns file with a specific id
     *
     * @param id id of file
     * @return file
     */
    @Override
    public Document getDocByID(UUID id) {
        return fileRepo.getById(id);
    }

    /**
     * Returns all files saved in application
     *
     * @return
     */
    @Override
    public List<Document> getAllDocs() {
        return fileRepo.findAll();
    }

    /**
     * Checks if a bucket exist in storage
     *
     * @param bucketName name of the bucket
     * @return true if exists else false
     */
    @Override
    public boolean bucketExists(String bucketName) {
        return doesBucketExist(bucketName);
    }

    /**
     * creates new bucket with an specific name
     *
     * @param bucketName
     */
    @Override
    public void makeBucket(String bucketName) {
        createBucket(bucketName);
    }


    public String putObject(MultipartFile file, String bucketName, String fileType, UUID uploader, UUID postId, int universityId, int courseId) {
        try {
            bucketName = !bucketName.isBlank() ? bucketName : minioConfig.getBucket();
            if (!this.bucketExists(bucketName)) {
                this.makeBucket(bucketName);
            }
            var fileName = file.getOriginalFilename();
            var id = UUID.randomUUID();
            var objectName = id.toString().replaceAll("-", "")
                    + fileName.substring(fileName.lastIndexOf("."));
            putObjectIntern(fileName, fileType, file, uploader, bucketName,
                    objectName, postId, universityId, courseId);
            return minioConfig.getEndpoint() + "/" + bucketName + "/" + objectName;
        } catch (Exception e) {
            e.printStackTrace();
            return " Upload failed ";
        }
    }

    /**
     * @param bucketName
     * @param objectName
     * @return
     */
    @Override
    public InputStream downloadObject(String bucketName, String objectName) {
        return getObject(bucketName, objectName);
    }

    /**
     * @param name
     * @return
     */
    @SneakyThrows
    public boolean doesBucketExist(String name) {
        boolean found =
                minioClient.bucketExists(BucketExistsArgs.builder().bucket(name).build());
        if (found) {
            System.out.println(name + " exists");
        } else {
            System.out.println(name + " does not exist");
        }
        return found;
    }

    /**
     * @param name
     * @return
     */
    @SneakyThrows
    public boolean createBucket(String name) {
        if (doesBucketExist(name)) {
            minioClient.makeBucket(
                    MakeBucketArgs.builder()
                            .bucket(name)
                            .build());

            return true;
        } else {
            return false;
        }
    }


    @SneakyThrows
    public void putObjectIntern(String fileName, String fileType, MultipartFile multipartFile, UUID uploader, String bucketName,
                                String objectName, UUID postId, int universityId, int courseId) {
        InputStream inputStream = new ByteArrayInputStream(multipartFile.getBytes());
        minioClient.putObject(
                PutObjectArgs.builder().bucket(bucketName).object(objectName).stream(
                                inputStream, -1, minioConfig.getMaxFileSize())
                        .contentType(fileType)
                        .build());

        saveDocData(new Document(
                UUID.randomUUID(),
                fileName,
                fileType,
                multipartFile.getSize(),
                uploader,
                null,
                LocalDateTime.now(),
                bucketName,
                objectName,
                postId,
                universityId,
                courseId
        ));
    }

    /**
     * @param bucketName
     * @param objectName
     * @return
     */
    @SneakyThrows
    public InputStream getObject(String bucketName, String objectName) {

        if (doesBucketExist(bucketName))  {
            var statObject = statObject(bucketName, objectName);
            if (statObject != null && statObject.size() > 0) {
                return  minioClient.getObject(
                                GetObjectArgs.builder()
                                        .bucket(bucketName)
                                        .object(objectName)
                                        .build());
            }
        }
        return null;
    }

    /**
     * @param bucketName
     * @param objectName
     * @return
     */
    @SneakyThrows
    public StatObjectResponse statObject(String bucketName, String objectName) {
        return (doesBucketExist(bucketName))
                ? (minioClient.statObject(
                        StatObjectArgs.builder().bucket(bucketName).object(objectName).build()))
                : null;
    }


}
