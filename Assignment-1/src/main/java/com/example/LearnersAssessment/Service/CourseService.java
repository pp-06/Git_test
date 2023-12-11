package com.example.LearnersAssessment.Service;

import com.example.LearnersAssessment.Entity.Courses;
import com.example.LearnersAssessment.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Service
public class CourseService {

    @Autowired //Inject dependency of LearnerRepository
    private CourseRepository courseRepository;


    // Get all Courses
    public List<Courses> getAllCourses(){
        // Return all learners in a database
        return courseRepository.findAll();
    }

    // Get Courses by id
    public Courses getCoursesById(@PathVariable("course_Id") int id){
        return courseRepository.findById(id).get();
    }

    // Create Course
    public Courses createCourses(Courses courses){
        return courseRepository.save(courses);
    }

    //Check for course id exist
    public boolean checkCourseExistById(int id){
        return courseRepository.existsById(id);
    }
    // Update courses
    public Courses updateCourseById(Courses course){
        boolean courseIdExist = checkCourseExistById(course.getCourse_Id());
        if(!courseIdExist){
            throw new RuntimeException("User id"+ course.getCourse_Id() + "doesn't exist");
        }
        else if((course.getCourse_name() == null) && (course.getCourse_description() == null) ){
            throw new RuntimeException("Provide information");
        }
        else{
            course.setCourse_name(course.getCourse_name());
            course.setCourse_description(course.getCourse_description());
            courseRepository.save(course);
            return course;
        }
    }

    //Remove Course
    public void removeCoursesById(int id){
        Optional<Courses> tempUser = courseRepository.findById(id);
        if(tempUser.isEmpty()){
            throw new RuntimeException("Course id" + id + "doesn't exist");
        }
        courseRepository.deleteById(id);
    }

    //Remove all Courses
    public void removeAllCourses(){
        courseRepository.deleteAll();
    }

    //Count all the records
    public long numberOfRecords(){
        return courseRepository.count();
    }

}
