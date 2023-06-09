package com.example.redditclonefinalproject.securities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 8/29/22
 * Time      : 15:45
 * Filename  : JwtUserDetails
 */
public class JwtUserDetails implements UserDetails {


    private final String username;

    private final String password;

    private final String email;
    private final Collection<? extends GrantedAuthority> authorities;

    private final boolean trangThai;

    public JwtUserDetails(String username, String password, String email, Collection<? extends GrantedAuthority> authorities, boolean trangThai) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.trangThai = trangThai;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return trangThai;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return trangThai;
    }
}
