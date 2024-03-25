package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public List<User> getAllUser()

    {
        return userRepository.findAll();
    }
    public void adduser(User user)

    {
        userRepository.save(user);
    }
    public Boolean DeleteUser(Integer id){
        User user=userRepository.getById(id);
        if (user ==null){
            return false;
        }
        userRepository.delete(user);
        return true;
    }
    public Boolean updateUser( Integer id,User user){
        User u=userRepository.getById(id);
        if (u==null){
            return false;
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setPassword(user.getPassword());
        u.setRole(user.getRole());
        userRepository.save(user);
        return true;
    }
}