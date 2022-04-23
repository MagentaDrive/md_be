package magentadrive.user_service.web.SignIn;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

public class SignInRequest {

    @Getter
    @NotBlank
    private String username;

    @Getter
    @NotBlank
    private String password;


}
