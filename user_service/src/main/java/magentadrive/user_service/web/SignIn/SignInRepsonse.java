package magentadrive.user_service.web.SignIn;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public class SignInRepsonse {
    @Getter
    @Setter
    private String vorname;
    @Getter
    @Setter
    private String nachname;
    @Getter
    @Setter
    private List<String> roles;
    @Getter
    @Setter
    private String token;
    @Getter
    @Setter
    private String type = "Bearer";
    @Getter
    @Setter
    private UUID id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String email;

    public SignInRepsonse(String accessToken, UUID id, String vorname, String nachname, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
        this.roles = roles;
    }
}
