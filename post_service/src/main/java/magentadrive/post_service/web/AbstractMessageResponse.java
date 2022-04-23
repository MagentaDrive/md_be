package magentadrive.post_service.web;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractMessageResponse {
    @Getter
    @Setter
    private String message;

    public AbstractMessageResponse(String message) {
        this.message = message;
    }


}
