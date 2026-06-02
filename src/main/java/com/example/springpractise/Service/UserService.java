package com.example.springpractise.Service;

import com.example.springpractise.Model.UserModel;
import com.example.springpractise.Model.UserPrincipal;
import com.example.springpractise.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userrepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userrepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Usern not found"));

        return new UserPrincipal(user);
    }
}
