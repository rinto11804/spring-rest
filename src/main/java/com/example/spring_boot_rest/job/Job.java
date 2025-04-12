package com.example.spring_boot_rest.job;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Job {
  private int id;
  private String postProfile;
  private String postDescription;
  private int reqExperience;
  private List<String> techStack;  
}
