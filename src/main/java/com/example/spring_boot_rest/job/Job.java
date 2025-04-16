package com.example.spring_boot_rest.job;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Job {
  @Id
  private int id;
  private String postProfile;
  private String postDescription;
  private int reqExperience;
  private List<String> techStack;  
}
