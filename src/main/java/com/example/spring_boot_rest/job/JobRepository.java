package com.example.spring_boot_rest.job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<Job,Integer> {

    List<Job> findByPostProfileContainingOrPostDescriptionContaining(String profile,String description);
    
}
