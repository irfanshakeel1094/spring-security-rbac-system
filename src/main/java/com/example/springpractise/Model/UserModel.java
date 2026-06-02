package com.example.springpractise.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String phonenumber;
    private String role;

    public UserModel(Integer id, String username, String password, String email, String phonenumber, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.phonenumber = phonenumber;
        this.email = email;
    }


    public boolean isEmpty() {
        if(username == null || password == null || role == null){
            return true;
        }return false;
        }
}
