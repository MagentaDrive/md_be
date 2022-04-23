package magentadrive.user_service.repos;


import magentadrive.user_service.models.Role;
import magentadrive.user_service.models.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRoleName(ERole roleName);


}
