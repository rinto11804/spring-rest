package com.example.spring_boot_rest.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

     @Autowired
     private JobRepository jobRepository;

     public List<Job> getAllJobs() {
          return jobRepository.findAll();
     }

     public JobResponseDTO getJobById(int jobId) {
          Job job =  jobRepository.getReferenceById(jobId);
          JobResponseDTO res = new JobResponseDTO();
          res.setId(jobId);
          res.setPostDescription(job.getPostDescription());
          res.setPostProfile(job.getPostProfile());
          res.setReqExperience(job.getReqExperience());
          res.setTechStack(job.getTechStack());

          return res;
     }

     public void addJob(Job job) {
          jobRepository.save(job);
     }

     public JobResponseDTO updateJob(Job newjob) {
          Job job = jobRepository.save(newjob);
          JobResponseDTO res = new JobResponseDTO();
          res.setId(job.getId());
          res.setPostDescription(job.getPostDescription());
          res.setPostProfile(job.getPostProfile());
          res.setReqExperience(job.getReqExperience());
          res.setTechStack(job.getTechStack());
          return res;
     }

     public Job deleteJob(int id) {
          Job job = jobRepository.getReferenceById(id);
          jobRepository.delete(job);
          return job;
     }

     public List<Job> search(String keyword) {
          
          return jobRepository.findByPostProfileContainingOrPostDescriptionContaining(keyword,keyword);
     }

     public void loadData() {
          List<Job> jobs = List.of(
                    new Job(
                              3,
                              "DevOps Engineer",
                              "Cloud infrastructure and CI/CD expertise required",
                              5,
                              List.of("AWS", "Docker", "Kubernetes", "Terraform", "Jenkins")),

                    new Job(
                              4,
                              "Data Scientist",
                              "Machine learning and data analysis specialist",
                              4,
                              List.of("Python", "TensorFlow", "Pandas", "SQL", "NumPy")),

                    new Job(
                              5,
                              "Mobile Developer",
                              "Android/iOS app development position",
                              2,
                              List.of("Kotlin", "Swift", "Flutter", "Firebase")),

                    new Job(
                              6,
                              "Full Stack Developer",
                              "End-to-end web development role",
                              3,
                              List.of("JavaScript", "Node.js", "React", "MongoDB", "Express")),

                    new Job(
                              7,
                              "QA Engineer",
                              "Manual and automated testing specialist",
                              1,
                              List.of("Selenium", "JUnit", "TestNG", "Postman")),

                    new Job(
                              8,
                              "UX Designer",
                              "User experience and interface design expert",
                              4,
                              List.of("Figma", "Sketch", "Adobe XD", "User Research", "Prototyping")),

                    new Job(
                              9,
                              "Backend Developer",
                              "Building scalable server-side applications",
                              3,
                              List.of("Python", "Django", "PostgreSQL", "REST API")),

                    new Job(
                              10,
                              "Cloud Architect",
                              "Designing and implementing cloud solutions",
                              7,
                              List.of("AWS", "Azure", "GCP", "Microservices", "Serverless")));

          jobRepository.saveAll(jobs);
     }
}
