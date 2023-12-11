package com.example.LearnersAssessment.Entity;


import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Courses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int course_Id;
    private String course_name;
    private String course_description;

}
