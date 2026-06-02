package com.example.springpractise.Config;

import com.example.springpractise.Model.UserModel;
import com.example.springpractise.Repository.UserRepository;
import com.example.springpractise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
@EnableWebSecurity
public class Configuration {
        @Autowired
        private UserRepository userRepository;
        @Bean
        public SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(requests->requests
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/user/**").hasRole("USER")
                        .requestMatchers("/login/**").hasRole("USER")
                        .anyRequest().authenticated()

                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
        }
        @Bean
        public AuthenticationProvider authenticationprovider(UserService user){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(user);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
        }
        @Bean
        public CommandLineRunner init(UserRepository userre){
               return args->{
                       if(userre.findByUsername("admin").isEmpty()){
                               UserModel admin = new UserModel();
                               admin.setUsername("admin");
                               admin.setPassword("admin123");
                               admin.setRole("ADMIN");
                               userre.save(admin);
                       }
               };
        }
}
