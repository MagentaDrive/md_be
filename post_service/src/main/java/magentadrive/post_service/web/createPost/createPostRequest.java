package magentadrive.post_service.web.createPost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import magentadrive.post_service.model.enums.EStatus;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
public class createPostRequest {

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
}
