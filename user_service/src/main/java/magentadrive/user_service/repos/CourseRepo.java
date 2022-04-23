package magentadrive.user_service.repos;

import magentadrive.user_service.models.Course;
import magentadrive.user_service.models.enums.ECourse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {

    int findByName(String name);


}
