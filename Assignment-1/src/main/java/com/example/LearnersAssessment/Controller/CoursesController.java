package com.example.LearnersAssessment.Controller;

import com.example.LearnersAssessment.Entity.Courses;
import com.example.LearnersAssessment.Entity.Learners;
import com.example.LearnersAssessment.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CoursesController {

    @Autowired
    CourseService courseService;

    @GetMapping("/getAll")
    public List<Courses> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/getById/{id}")
    public Courses getCoursesById(@PathVariable int id){
        return courseService.getCoursesById(id);
    }

    //Adding new learner
    @PostMapping("/add")
    public Courses addCourse (@RequestBody Courses course){
        return courseService.createCourses(course);
    }

    //Update Learner
    @PutMapping("/update")
    public Courses updateCourses(@RequestBody Courses course){
        return courseService.updateCourseById(course);
    }

    //Exist or not
    @GetMapping("/exist/{id}")
    public boolean  existCourse(@PathVariable int id){
        return courseService.checkCourseExistById(id);
    }
    @GetMapping("del/{id}")
    public void removeCourseById(@PathVariable int id){
        courseService.removeCoursesById(id);
    }

    @GetMapping("/delAll")
    public void removeAll(){
        courseService.removeAllCourses();
    }

    //Count of records
    @GetMapping("/count")
    public long getCount(){
        return courseService.numberOfRecords();
    }

}
