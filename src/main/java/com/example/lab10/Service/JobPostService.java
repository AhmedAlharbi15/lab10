package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;
    public List<JobPost> getAllJobPost()

    {
        return jobPostRepository.findAll();
    }
    public void addjobpostr(JobPost jobPost)

    {
        jobPostRepository.save(jobPost);
    }
    public Boolean Deletejobpost(Integer id){
        JobPost jobPost=jobPostRepository.getById(id);
        if (jobPost ==null){
            return false;
        }
        jobPostRepository.delete(jobPost);
        return true;
    }
    public Boolean updatejobpost( Integer id,JobPost jobPost){
        JobPost j=jobPostRepository.getById(id);
        if (j==null){
            return false;
        }
        j.setTitle(jobPost.getTitle());
        j.setDescription(jobPost.getDescription());
        j.setLocation(jobPost.getLocation());
        j.setSalary(jobPost.getSalary());
        j.setPostingDate(jobPost.getPostingDate());

        jobPostRepository.save(jobPost);
        return true;
    }
}
