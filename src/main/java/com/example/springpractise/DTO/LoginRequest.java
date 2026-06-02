package com.example.springpractise.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private long id;
    private String password;
}
