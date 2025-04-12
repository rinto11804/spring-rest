package com.example.spring_boot_rest.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "http://localhost:5173" )
public class JobController {
     
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/job/{jobId}")
    public Job getJobById(@PathVariable int jobId) {
        return jobService.getJobById(jobId);
    }

    @PostMapping("/job")
    public void createJob(@RequestBody Job job) {
        jobService.addJob(job);
    }

    @PutMapping("/job")
    public Job updateJob(@RequestBody Job job) {
        return jobService.updateJob(job);
    }

    @DeleteMapping("/job/{jobId}")
    public Job deleJob(@PathVariable int jobId) {
        return jobService.deleteJob(jobId);
    }
}
