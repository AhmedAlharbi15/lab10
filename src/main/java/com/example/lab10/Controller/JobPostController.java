package com.example.lab10.Controller;

import com.example.lab10.Api.Api;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Model.User;
import com.example.lab10.Service.JobPostService;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobpost")
@RequiredArgsConstructor
public class JobPostController {
    private final JobPostService jobPostService;

    @GetMapping("/get")
    public ResponseEntity getAlljobpost()
    {
        return ResponseEntity.status(200).body(jobPostService.getAllJobPost());
    }

    @PostMapping("/add")
    public ResponseEntity addjobpost(@RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();

        }
        jobPostService.addjobpostr(jobPost);
        return ResponseEntity.status(200).body(new Api("jobpost added"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletejobpost(@PathVariable Integer id) {
        Boolean isDelete = jobPostService.Deletejobpost(id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new Api("delete"));
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @PutMapping("/up")
    public ResponseEntity updatejobpost(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Up");
        }
        Boolean isUpdate = jobPostService.updatejobpost(id, jobPost);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new Api("jobpost Updated"));
        }
        return ResponseEntity.status(400).body("Wrong ID");

    }
}
