package magentadrive.user_service.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Setter
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {

    @Getter
    @GeneratedValue
    @Id
    @Column(name = "user_id")
    private UUID id;
    @Getter
    @NotBlank
    @Size(max = 20)
    private String username;
    @Getter
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    @Getter
    @NotBlank
    @Size(max = 120)
    private String password;
    @Getter
    @NotBlank
    @Size(max = 20)
    private String firstName;
    @Getter
    @NotBlank
    @Size(max = 20)
    private String lastName;
    @Getter
    @NotBlank
    private int universityId;
    @Getter
    @NotBlank
    private int courseId;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password, String firstName, String lastName, int universityId, int courseId) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.universityId = universityId;
        this.courseId = courseId;
    }

    public User() {}


}

