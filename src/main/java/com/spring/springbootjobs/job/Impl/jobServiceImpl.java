package com.spring.springbootjobs.job.Impl;

import com.spring.springbootjobs.job.Job;
import com.spring.springbootjobs.job.JobRepo;
import com.spring.springbootjobs.job.jobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class jobServiceImpl implements jobService {

    //private List<Job> jobs = new ArrayList<>();
    JobRepo jobRepo;

    public jobServiceImpl(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    private Long nextId = 1L;
    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobRepo.save(job);
    }

    @Override
    public Job getJobById(Long id) {
      return jobRepo.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
       try {
           jobRepo.deleteById(id);
           return true;
       }catch (Exception e){
           return false;
       }
    }
    @Override
    public boolean updateJobById(Long id, Job updateJobById){
        Optional<Job> jobOptional=jobRepo.findById(id);
            if (jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(updateJobById.getTitle());
                job.setDescription(updateJobById.getDescription());
                job.setMinSalary(updateJobById.getMinSalary());
                job.setMaxSalary(updateJobById.getMaxSalary());
                job.setLocation(updateJobById.getLocation());
                jobRepo.save(job);
                return true;
            }

        return false;
    }

}
