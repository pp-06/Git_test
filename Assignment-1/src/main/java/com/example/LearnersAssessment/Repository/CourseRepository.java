package com.example.LearnersAssessment.Repository;

import com.example.LearnersAssessment.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {
    // JPA Repo is extended to provide CRUD functionality to the Entity. Parameter -> Entity class and Id type
}
