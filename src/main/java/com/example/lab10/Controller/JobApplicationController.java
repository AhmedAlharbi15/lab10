package com.example.lab10.Controller;

import com.example.lab10.Api.Api;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Model.User;
import com.example.lab10.Service.JobApplicationService;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/jobapplication")
@RequiredArgsConstructor
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getAlljobapp()
    {
        return ResponseEntity.status(200).body(jobApplicationService.getAllJobApp());
    }

}
