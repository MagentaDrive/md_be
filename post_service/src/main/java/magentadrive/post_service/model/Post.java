package magentadrive.post_service.model;

import lombok.Getter;
import lombok.Setter;
import magentadrive.post_service.model.enums.EStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Post")
public class Post {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    private UUID postId;

    @Getter
    @Setter
    @NotBlank
    private String title;

    @Getter
    @Setter
    @NotBlank
    private int userId;

    @Getter
    @Setter
    @NotBlank
    private int documentId;

    @Getter
    @Setter
    @NotBlank
    private LocalDateTime date;

    @Getter
    @Setter
    @NotBlank
    private int hochschuleId;

    @Getter
    @Setter
    @NotBlank
    private int studiengangId;

    @Getter
    @Setter
    @NotBlank
    private String textContent;

    @Getter
    @Setter
    @NotBlank
    @Enumerated(value = EnumType.STRING)
    private EStatus status;


    public Post() {
    }

    public Post(String title, int userId, int documentId, LocalDateTime date, int hochschuleId, int studiengangId, String textContent, EStatus status) {
        this.title = title;
        this.userId = userId;
        this.documentId = documentId;
        this.date = date;
        this.hochschuleId = hochschuleId;
        this.studiengangId = studiengangId;
        this.textContent = textContent;
        this.status = status;
    }
}
