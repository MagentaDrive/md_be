package magentadrive.storage_service.DocumentService.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Text response
 */
@AllArgsConstructor
public abstract class AbstractMessageResponse {

    @Getter
    @Setter
    private String message;


}
