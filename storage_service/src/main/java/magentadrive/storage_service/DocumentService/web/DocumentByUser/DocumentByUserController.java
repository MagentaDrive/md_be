package magentadrive.storage_service.DocumentService.web.DocumentByUser;


import magentadrive.storage_service.DocumentService.services.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RequestMapping("/storage")
@RestController
public class DocumentByUserController {

    private final FileService fileService;


    public DocumentByUserController(FileService fileService) {
        this.fileService = fileService;
    }


    @GetMapping("/user/{Id}/files")
    public ResponseEntity<DocumentByUserResponse> getDocsByUser(@Valid @PathVariable UUID Id){
       var docs =  fileService.getAllDocsFromUser(Id);
        return ResponseEntity.ok().body(
                new DocumentByUserResponse(
                        docs
                )
        );
    }
}
