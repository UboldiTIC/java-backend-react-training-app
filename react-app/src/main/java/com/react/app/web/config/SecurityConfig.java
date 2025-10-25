package com.react.app.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth -> auth
                //        .requestMatchers(HttpMethod.GET, "/api/device/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/device/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/api/device/**").hasRole("ADMIN")
                        //Con hasAutority asignamos un permiso específico a un usuario determinado, debe estar antes de la línea que solo lo permite a ADMIN:
                        //.requestMatchers(HttpMethod.PUT, "/api/device/**").hasAuthority("update_device")
                        .requestMatchers(HttpMethod.PUT, "/api/device/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/device/**").hasRole("ADMIN")
                        .requestMatchers("/api/reservations/**").hasAnyRole("ADMIN", "USER")
                //        .requestMatchers(HttpMethod.PUT).denyAll()
                        .anyRequest()
                        .authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    /*
    // Crear usuarios en memoria para probar.
    @Bean
    public UserDetailsService memoryUsers() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

        UserDetails teacher = User.builder()
                .username("teacher")
                .password(passwordEncoder().encode("teacher"))
                .roles("TEACHER")
                .build();

        return new InMemoryUserDetailsManager(admin, teacher);
    }
    */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
