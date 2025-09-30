package com.sparta.global.domain.security;

import com.sparta.member.domain.entity.Users;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
public class UserDetailsImpl implements UserDetails {

    private Long seq;
    private String email;
    private String password;
    private String name;

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    public static Users of(UserDetails userDetails) {
        UserDetailsImpl _userDetails = (UserDetailsImpl)userDetails;
        Users user = new Users();
        user.setSeq(_userDetails.getSeq());
        user.setName(_userDetails.getName());
        user.setPassword(_userDetails.getPassword());
        user.setEmail(_userDetails.getEmail());
        return user;
    }
}
