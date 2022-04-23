package magentadrive.post_service.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Comment")
public class Comment {

    @Getter
    @Setter
    @Id
    @GeneratedValue
    private UUID commentId;

    @Getter
    @Setter
    @NotBlank
    private int userId;

    @Getter
    @Setter
    @NotBlank
    private String title;

    @Getter
    @Setter
    @NotBlank
    private String textContent;

    @Getter
    @Setter
    @NotBlank
    private int postId;

    @Getter
    @Setter
    @NotBlank
    private LocalDateTime date;

    public Comment(int userId, String title, int postId, String textContent,LocalDateTime date) {
        this.userId = userId;
        this.title = title;
        this.postId = postId;
        this.textContent = textContent;
        this.date = date;
    }

    public Comment() {

    }
}
