package magentadrive.user_service.web.UserInformation;


import magentadrive.user_service.services.UniversityCourseService;
import magentadrive.user_service.services.UserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserInformationController {

    private final UniversityCourseService UniCourseservice;
    private final UserDetailsServiceImpl userDetailsService;

    public UserInformationController(UniversityCourseService UniCourseservice, UserDetailsServiceImpl userDetailsService) {
        this.UniCourseservice = UniCourseservice;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserInfos(@Valid  @PathVariable UUID id) {
        int uniId, courseID, yearCourseBegin;
        String course, uni;

        courseID = userDetailsService.getCourseIDByUserID(id);
        uniId = userDetailsService.getUniversityByUserID(id);

        course = UniCourseservice.getCourse(courseID);
        uni = UniCourseservice.getUniversity(uniId);
        yearCourseBegin = UniCourseservice.getCourseBegin(courseID);

        return ResponseEntity.ok().body(
                new UserInformationResponse(
                        course,
                        yearCourseBegin,
                        uni
                )
        );


    }
}