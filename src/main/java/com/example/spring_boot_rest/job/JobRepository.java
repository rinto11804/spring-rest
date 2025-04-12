package com.example.spring_boot_rest.job;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class JobRepository {
    private List<Job> jobs = new ArrayList<>();

    public JobRepository() {
        jobs.add(new Job(
                2,
                "Frontend Developer",
                "Looking for experienced React developer",
                3,
                List.of("JavaScript", "React", "HTML/CSS", "Redux")));

        jobs.add(new Job(
                3,
                "DevOps Engineer",
                "Cloud infrastructure and CI/CD expertise required",
                5,
                List.of("AWS", "Docker", "Kubernetes", "Terraform", "Jenkins")));

        jobs.add(new Job(
                4,
                "Data Scientist",
                "Machine learning and data analysis specialist",
                4,
                List.of("Python", "TensorFlow", "Pandas", "SQL", "NumPy")));

        jobs.add(new Job(
                5,
                "Mobile Developer",
                "Android/iOS app development position",
                2,
                List.of("Kotlin", "Swift", "Flutter", "Firebase")));

        jobs.add(new Job(
                6,
                "Full Stack Developer",
                "End-to-end web development role",
                3,
                List.of("JavaScript", "Node.js", "React", "MongoDB", "Express")));

        jobs.add(new Job(
                7,
                "QA Engineer",
                "Manual and automated testing specialist",
                1,
                List.of("Selenium", "JUnit", "TestNG", "Postman")));

        jobs.add(new Job(
                8,
                "UX Designer",
                "User experience and interface design expert",
                4,
                List.of("Figma", "Sketch", "Adobe XD", "User Research", "Prototyping")));

        jobs.add(new Job(
                9,
                "Backend Developer",
                "Building scalable server-side applications",
                3,
                List.of("Python", "Django", "PostgreSQL", "REST API")));

        jobs.add(new Job(
                10,
                "Cloud Architect",
                "Designing and implementing cloud solutions",
                7,
                List.of("AWS", "Azure", "GCP", "Microservices", "Serverless")));
    }


    public List<Job> getAllJobs() {
        return jobs;
    }

    public void addJob(Job job) {
        jobs.add(job);
    }

    public Job getJobById(int id) {
        for(Job job : jobs) {
            if(job.getId() == id) {
                return job;
            }
        }

        return null;
    }

    public Job updateJob(Job newJob) {
        for(int i = 0; i < jobs.size();i++) {
            if(jobs.get(i).getId() == newJob.getId()) {
                jobs.set(i, newJob);
                return newJob;
            }
        }

        return null;
    }

    public Job deleteJob(int id) {
        for(int i = 0; i < jobs.size();i++) {
            if(jobs.get(i).getId() == id) {
                return jobs.remove(i);
            }
        }

        return null;     
    }
}
