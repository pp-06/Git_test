package com.example.LearnersAssessment.Controller;

import com.example.LearnersAssessment.Entity.Learners;
import com.example.LearnersAssessment.Service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("learners")
public class LearnersController {

    @Autowired
    private LearnerService learnerService;

    @GetMapping("/getAll")
    public List<Learners> getAllLearners(){
        return learnerService.getAllLearners();
    }
    @GetMapping("/getById/{id}")
    public Learners getLearnersById(@PathVariable int id){
        return learnerService.getLearnersById(id);
    }

    //Adding new learner
    @PostMapping("/add")
    public Learners addLearner (@RequestBody Learners learners){
        return learnerService.createLearners(learners);
    }

    //Update Learner
    @PutMapping("/update")
    public Learners updateLearners(@RequestBody Learners learners){
        return learnerService.updateLearnersById(learners);
    }

    //Remove
    @GetMapping("/del/{id}")
    public String removeLearnerById(@PathVariable int id){
        try{
            learnerService.removeLearnersById(id);
            return "Learner with id:"+id+" removed";

        }
        catch (Exception e)
        {
            return "Learner with id:"+id+"not found";
        }
    }

    //Delete all
    @GetMapping("/delAll")
    public String deleteAll(){
        learnerService.removeAllLearners();
        return "Deleted all Learners";
    }

    //Exist or not
    @GetMapping("/exist")
    public String  existLearner(@PathVariable int id){
        if(learnerService.checkForLearner(id)){
            return "Learner Found";
        }
        else{
            return "Learner not found";
        }
    }
}
