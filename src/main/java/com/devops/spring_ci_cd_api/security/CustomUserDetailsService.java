package com.devops.spring_ci_cd_api.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    // Simuler une base de données en mémoire
    private final List<UserDetails> users = List.of(
        User.withUsername("testuser")
            .password("{noop}password") // {noop} signifie pas d'encodage (à remplacer par BCrypt en prod)
            .roles("USER")
            .build()
    );

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
            .filter(user -> user.getUsername().equals(username))
            .findFirst()
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }
}
