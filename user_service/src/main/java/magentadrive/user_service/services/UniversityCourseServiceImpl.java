package magentadrive.user_service.services;

import magentadrive.user_service.models.enums.ECourse;
import magentadrive.user_service.models.enums.EUniversity;
import magentadrive.user_service.repos.CourseRepo;
import magentadrive.user_service.repos.UniversityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UniversityCourseServiceImpl implements UniversityCourseService {

    @Autowired
    private CourseRepo courseRepo;
    @Autowired
    private UniversityRepo universityRepo;


    @Override
    public String getUniversity(int id) {
        EUniversity university;
        university = universityRepo.getById(id).getName();
        return university.toString();
    }

    @Override
    public String getCourse(int id) {
        ECourse course;
        course = courseRepo.getById(id).getName();
        return course.toString();
    }

    @Override
    public int getCourseBegin(int id) {
        int year_begin;
        year_begin = courseRepo.getById(id).getCourse_begin();
        return year_begin;
    }

    @Override
    public int getCourseIDbyName(String s) {
        var courses =  courseRepo.findAll().stream().filter(
                course -> course.getName().name().equalsIgnoreCase(s)).collect(Collectors.toList());
        return courses.get(0).getId();

    }

    @Override
    public int getUniversityIDbyName(String s) {
        var uni =  universityRepo.findAll().stream().filter(
                university -> university.getName().name().equalsIgnoreCase(s)).collect(Collectors.toList());


        return uni != null ?  uni.get(0).getId() : null;
    }


}
