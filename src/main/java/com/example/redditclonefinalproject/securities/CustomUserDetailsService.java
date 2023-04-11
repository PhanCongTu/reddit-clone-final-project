package com.example.redditclonefinalproject.securities;

import com.example.redditclonefinalproject.models.User;
import com.example.redditclonefinalproject.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 8/29/22
 * Time      : 15:54
 * Filename  : TaiKhoanDetailsService
 */
@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public JwtUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("Tài khoản có username %s không tồn tại", username)));
        return getUserDetails(user);
    }

    private JwtUserDetails getUserDetails(User user) {
        return new JwtUserDetails(
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()),
                user.isEnabled()
        );
    }
}
