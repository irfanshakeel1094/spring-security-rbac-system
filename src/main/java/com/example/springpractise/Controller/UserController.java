package com.example.springpractise.Controller;


import com.example.springpractise.Model.UserModel;
import com.example.springpractise.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserRepository userrepo;
    @PostMapping("/admin/create")
    public UserModel createUser(@RequestBody UserModel user){
        System.out.println("Username = " + user.getUsername());
        System.out.println("Password = " + user.getPassword());
        System.out.println("Role = " + user.getRole());
        return userrepo.save(user);
    }
    @GetMapping("/user/details")
    public ResponseEntity<?> getUserDetails(Authentication authentication){
        String username = authentication.getName();
        UserModel user = userrepo.findByUsername(username)
                .orElseThrow(()->new RuntimeException("Username not found"));
        return ResponseEntity.ok(user);
    }

}
