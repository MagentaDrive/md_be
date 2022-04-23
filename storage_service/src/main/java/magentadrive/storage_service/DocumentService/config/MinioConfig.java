package magentadrive.storage_service.DocumentService.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Configuration of the Minio client.
 * Values for client in application properties minio.*
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {

    private String endpoint;
    private int port;
    private String name;
    private String password;
    private boolean secure;
    private String bucket;
    private long maxFileSize;

    /**
     * @return configured client
     */
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .credentials(name, password)
                .endpoint(endpoint, port, secure)
                .build();
    }
}

