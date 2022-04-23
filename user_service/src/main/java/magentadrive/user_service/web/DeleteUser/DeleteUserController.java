package magentadrive.user_service.web.DeleteUser;


import magentadrive.user_service.services.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class DeleteUserController {

    private final UserDetailsServiceImpl userDetailsService;

    public DeleteUserController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@Valid @RequestBody DeleteUserRequest request, @PathVariable UUID id) {
        try {
            userDetailsService.deleteUserByID(id);
        }catch (Exception e){
           return  ResponseEntity.badRequest().body(
                    new DeleteUserResponse(
                            "Fehler beim Löschen des Users"
                    )
            );
        }
        return ResponseEntity.ok().body(
                new DeleteUserResponse(
                        "Der User mit der ID  wurde gelöscht"
                )
        );


    }
}