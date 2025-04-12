package com.example.spring_boot_rest.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

   public List<Job> getAllJobs() {
        return jobRepository.getAllJobs();
   } 

   public Job getJobById(int jobId) {
    return jobRepository.getJobById(jobId);
   }

   public void addJob(Job job) {
      jobRepository.addJob(job);
   }

   public Job updateJob(Job job) {
        return jobRepository.updateJob(job);
   }

   public Job deleteJob(int id) {
     return jobRepository.deleteJob(id);
   }

}
