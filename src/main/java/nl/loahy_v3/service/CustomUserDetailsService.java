package nl.loahy_v3.service;

import lombok.AllArgsConstructor;
import nl.loahy_v3.repository.UserRepository;
import nl.loahy_v3.dto.UserDto;
import nl.loahy_v3.model.Authority;
import nl.loahy_v3.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserService userService;
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) {

        UserDto userDto = userService.getUser(email);

        Optional<User> user = userRepository.findById(email);

        String password = user.get().getPassword();

        Set<Authority> authorities = userDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new org.springframework.security.core.userdetails.User(email, password, grantedAuthorities);
    }
}