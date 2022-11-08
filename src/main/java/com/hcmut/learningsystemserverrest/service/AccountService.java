package com.hcmut.learningsystemserverrest.service;

import com.hcmut.learningsystemserverrest.controller.customException.exception.InvalidAccountException;
import com.hcmut.learningsystemserverrest.domain.Account;
import com.hcmut.learningsystemserverrest.service.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String login(String username, String password) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            Account account = (Account) authenticate.getPrincipal();

            return jwtTokenUtil.generateAccessToken(account);
        } catch (BadCredentialsException ex) {
            throw new InvalidAccountException();
        }
    }
}
