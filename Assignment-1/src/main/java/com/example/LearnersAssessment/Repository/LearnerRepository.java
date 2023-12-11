package com.example.LearnersAssessment.Repository;

import com.example.LearnersAssessment.Entity.Learners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Using this class as a repository
public interface LearnerRepository extends JpaRepository<Learners, Integer> {
    // JPA Repo is extended to provide CRUD functionality to the Entity. Parameter -> Entity class and Id type
}
