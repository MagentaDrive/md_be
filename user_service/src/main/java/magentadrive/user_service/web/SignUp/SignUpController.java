package magentadrive.user_service.web.SignUp;


import magentadrive.user_service.models.Role;
import magentadrive.user_service.models.User;
import magentadrive.user_service.models.enums.ERole;
import magentadrive.user_service.repos.RoleRepository;
import magentadrive.user_service.repos.UserRepository;
import magentadrive.user_service.services.UniversityCourseService;
import magentadrive.user_service.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class SignUpController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserDetailsServiceImpl uds;
    @Autowired
    UniversityCourseService ucservice;

    @Autowired
    PasswordEncoder encoder;


    @PostMapping("/user")
    public ResponseEntity<SignUpResponse> SignUpUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new SignUpResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new SignUpResponse("Error: Email is already in use!"));
        }

        var hochschulname = signUpRequest.getHochschule();
            // Create new user's account
            var user = new User
                    (signUpRequest.getUsername(),
                            signUpRequest.getEmail(),
                            encoder.encode(signUpRequest.getPassword()),
                            signUpRequest.getVorname(),
                            signUpRequest.getNachname(),
                            ucservice.getUniversityIDbyName(
                                    hochschulname
                                    ),
                            ucservice.getCourseIDbyName(signUpRequest.getCourse())

                    );

        var strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            uds.initRole();
            Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {

                   if( role == "admin") {
                       Role adminRole = roleRepository.findByRoleName(ERole.ROLE_ADMIN)
                               .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                       roles.add(adminRole);
                   }

                   else {
                       Role userRole = roleRepository.findByRoleName(ERole.ROLE_USER)
                               .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                       roles.add(userRole);
                   }

            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new SignUpResponse("User registered successfully!"));
    }
}
