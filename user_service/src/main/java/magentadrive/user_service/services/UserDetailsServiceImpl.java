package magentadrive.user_service.services;

import magentadrive.user_service.models.Role;
import magentadrive.user_service.models.User;
import magentadrive.user_service.models.enums.ERole;
import magentadrive.user_service.repos.RoleRepository;
import magentadrive.user_service.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    private boolean isInit = false;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return UserDetailsImpl.build(user);
    }


    public int getCourseIDByUserID(UUID id) {
        int courseID;
        courseID = userRepository.getById(id).getCourseId();
        return courseID;
    }

    public int getUniversityByUserID(UUID id) {
        int universityID;
        universityID = userRepository.getById(id).getUniversityId();
        return universityID;
    }


    @Transactional
    public void deleteUserByID(UUID id){
        userRepository.deleteById(id);
    }




    public void initRole() {
         if(isInit){
             return;
         }
         else {
           var roleCount =   roleRepository.count();
           if( roleCount != 0){
               return;
           }
           roleRepository.save(
                   new Role(ERole.ROLE_USER));
             roleRepository.save(
                     new Role( ERole.ROLE_ADMIN));

         }
    }

}
