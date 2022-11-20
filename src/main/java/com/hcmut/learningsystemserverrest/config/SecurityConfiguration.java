package com.hcmut.learningsystemserverrest.config;

import com.hcmut.learningsystemserverrest.repository.AccountRepository;
import com.hcmut.learningsystemserverrest.service.filter.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class SecurityConfiguration {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    String[] pathAAO = new String[]{"/api/student","/api/employee", "/api/create/aao",
                                    "/api/create/manager", "/api/create/lecturer",
                                    "/api/create/student", "/api/create/faculty",
                                    "/api/create/student_status", "/api/create/class",
                                    "/api/create/subclass", "/api/aao", "/api/manager",
                                    "/api/lecturer", "/api/update/student_status"};

    String[] pathManager = new String[]{"/api/create/subject", "/api/create/prerequisite",
                                        "/api/subject/status"};

    String[] pathLecturer = new String[]{"/api/create/textbook"};

    String[] pathStudent = new String[]{"/api/attend", "/api/subclass/search"};

    String[] pathAOOManager = new String[]{"/api/student/faculty", "/api/lecturer/faculty",
                                            "/api/class/subject", "/api/class/faculty",
                                            "/api/student/{personID}", "/api/aao/{personID}",
                                            "/api/manager/{personID}", "/api/lecturer/{personID}"};

    String[] pathAAOManagerLecturer = new String[]{"/api/subclass_lecturer/{lecturerID}",
                                                    "/api/subclass/student"};

    String[] pathAAOManagerStudent = new String[]{"/api/student_status/{studentID}",
                                                    "/api/student_status/{studentID}/{semester}",
                                                    "/api/subclass_student/{studentID}"};

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return accountRepository.findByUsername(username)
                        .orElseThrow(
                                () -> new UsernameNotFoundException("User " + username + " not found"));
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, ex) -> {
                            response.sendError(
                                    HttpServletResponse.SC_UNAUTHORIZED,
                                    ex.getMessage()
                            );
                        }
                );
        http.authorizeRequests()
                .antMatchers("/api/account/login").permitAll()
                .antMatchers(pathAAO).hasAuthority("ROLE_AAO")
                .antMatchers(pathManager).hasAuthority("ROLE_MANAGER")
                .antMatchers(pathLecturer).hasAuthority("ROLE_LECTURER")
                .antMatchers(pathStudent).hasAuthority("ROLE_STUDENT")
                .antMatchers(pathAOOManager).hasAnyAuthority("ROLE_AAO", "ROLE_MANAGER")
                .antMatchers(pathAAOManagerLecturer).hasAnyAuthority("ROLE_AAO", "ROLE_MANAGER", "ROLE_LECTURER")
                .antMatchers(pathAAOManagerStudent).hasAnyAuthority("ROLE_AAO", "ROLE_MANAGER","ROLE_STUDENT")
                .anyRequest().authenticated();
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
