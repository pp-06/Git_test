package com.example.LearnersAssessment.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //Asks to make table of this class
public class Learners implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto generate Ids

    private int learner_id;
    private String learner_first_name;
    private String learner_last_name;
    private String learner_email;
    private String learner_password;
    private int course_id;



}
