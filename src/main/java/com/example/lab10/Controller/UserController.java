package com.example.lab10.Controller;

import com.example.lab10.Api.Api;
import com.example.lab10.Model.User;
import com.example.lab10.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAlluser() {
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("/add")
    public ResponseEntity adduser(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();

        }
        userService.adduser(user);
        return ResponseEntity.status(200).body(new Api("user added"));

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        Boolean isDelete = userService.DeleteUser(id);
        if (isDelete) {
            return ResponseEntity.status(200).body(new Api("delete"));
        }
        return ResponseEntity.status(400).body("Wrong id");
    }

    @PutMapping("/up")
    public ResponseEntity updateuser(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            String massage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("Up");
        }
        Boolean isUpdate = userService.updateUser(id, user);
        if (isUpdate) {
            return ResponseEntity.status(200).body(new Api("user Updated"));
        }
        return ResponseEntity.status(400).body("Wrong ID");

    }
}