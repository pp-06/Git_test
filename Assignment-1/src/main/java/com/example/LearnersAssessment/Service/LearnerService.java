package com.example.LearnersAssessment.Service;

import com.example.LearnersAssessment.Entity.Learners;
import com.example.LearnersAssessment.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //Using this class as a service
public class LearnerService {

    @Autowired //Inject dependency of LearnerRepository
    LearnerRepository learnerRepository;

    // Get all learners
    public List<Learners> getAllLearners(){
        // Return all learners in a database
        return learnerRepository.findAll();
    }

    // Get learner by id
    public Learners getLearnersById(int id){
        return learnerRepository.findById(id).get();
    }

    // Create User
    public Learners createLearners(Learners learners){
        return learnerRepository.save(learners);
    }


    // Update learners
    public Learners updateLearnersById(Learners learners){
        boolean learnerIdExist = checkForLearner(learners.getLearner_id());
        if(!learnerIdExist){
            throw new RuntimeException("User id"+ learners.getLearner_id() + "doesn't exist");
        }
        else if((learners.getLearner_first_name() == null) && (learners.getLearner_last_name() == null) && (learners.getLearner_email() == null) && (learners.getLearner_password() == null) ){
            throw new RuntimeException("Provide information");
        }
        else{
            learners.setLearner_last_name(learners.getLearner_last_name());
            learners.setLearner_first_name(learners.getLearner_first_name());
            learners.setLearner_password(learners.getLearner_password());
            learners.setLearner_email(learners.getLearner_email());
            learners.setCourse_id(learners.getCourse_id());
            learnerRepository.save(learners);
            return learners;
        }
    }

    //Remove User
    public void removeLearnersById(int id){
        Optional<Learners> tempUser = learnerRepository.findById(id);
        if(tempUser.isEmpty()){
            throw new RuntimeException("User id" + id + "doesn't exist");
        }
        learnerRepository.deleteById(id);
    }

    //Remove all learners
    public void removeAllLearners(){
        learnerRepository.deleteAll();
    }

    //Check for id
    public boolean checkForLearner(int id) {
       return learnerRepository.existsById(id);
    }
    //Count all the records
    public long numberOfRecords(){
        return learnerRepository.count();
    }
}
