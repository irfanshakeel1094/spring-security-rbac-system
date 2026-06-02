package com.example.springpractise.Config;

import com.example.springpractise.Model.UserModel;
import com.example.springpractise.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initi (UserRepository userrepo){
        return args ->{
            if(userrepo.findByUsername("admin").isEmpty()){
                UserModel admin = new UserModel();
                admin.setUsername("admin");
                admin.setPassword("admin123");
                admin.setEmail("admin@gmail.com");
                admin.setRole("ADMIN");
                admin.setPhonenumber("9845125662");
                userrepo.save(admin);
                System.out.println("Admin Created");
            }
        };
    }
}
