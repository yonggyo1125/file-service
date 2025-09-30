package com.sparta.global.infrastructure.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        String email = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // String : anonymous - 비회원, UserDetails
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            email = userDetails.getUsername();
        }

        return Optional.ofNullable(email);
    }
}
