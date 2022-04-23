package magentadrive.user_service.services;

public interface UniversityCourseService {

    String getUniversity(int id);

    String getCourse(int id);

    int getCourseBegin(int id);

    int getCourseIDbyName(String s);

    int getUniversityIDbyName(String s);

}
