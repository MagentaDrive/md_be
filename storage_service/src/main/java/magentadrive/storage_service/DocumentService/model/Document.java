package magentadrive.storage_service.DocumentService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document")
public class Document {

    @Getter
    @Id
    @Column(name = "document_id")
    private UUID id;
    @Getter
    @Setter
    @NotNull
    private String title;
    @Getter
    @NotNull
    private String filetype;
    @Getter
    @NotNull
    private long fileSize;

    @Getter
    @NotNull
    private UUID userId;

    @Getter
    private LocalDateTime deletionDate;
    @Getter
    @NotNull
    private LocalDateTime uploadDate;
    @Getter
    @NotNull
    private String bucket;
    @Getter
    @NotNull
    private String objectName;
    @Getter
    private UUID postId;
    @Getter
    @NotNull
    private int universityId;

    @Getter
    @NotNull
    private int courseID;

}
