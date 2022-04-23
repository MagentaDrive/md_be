package magentadrive.user_service.repos;


import magentadrive.user_service.models.University;
import magentadrive.user_service.models.enums.ECourse;
import magentadrive.user_service.models.enums.EUniversity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepo extends JpaRepository<University, Integer> {

    int findByName(ECourse name);
}
