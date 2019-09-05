package com.example.hotelmanagenetsystem.controller;

import com.example.hotelmanagenetsystem.model.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DatabaseLoader implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
    }
}
