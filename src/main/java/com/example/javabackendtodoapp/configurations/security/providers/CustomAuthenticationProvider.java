package com.example.javabackendtodoapp.configurations.security.providers;

import com.example.javabackendtodoapp.configurations.security.authentication.ApiKeyAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Value("${secret.key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAuthentication apiKeyAuthentication = (ApiKeyAuthentication) authentication;
        String headerKey = apiKeyAuthentication.getKey();
        if (key.equals(headerKey)) {
            return new ApiKeyAuthentication(true, null);
        }
        throw new BadCredentialsException("Invalid credentials!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthentication.class.equals(authentication);
    }
}
