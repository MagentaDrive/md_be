package magentadrive.user_service.web.SignUp;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {

    @Getter
    @NotBlank
    @Size(min = 3, max = 20)
    private String vorname;

    @Getter
    @NotBlank
    @Size(min = 3, max = 20)
    private String nachname;

    @Getter
    @NotBlank
    @Size(min = 3, max = 20)
    private String hochschule;

    @Getter
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @Getter
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Getter
    private Set<String> role;

    @Getter
    private String password;

    @Getter
    private String course;
// TODO add course
}
