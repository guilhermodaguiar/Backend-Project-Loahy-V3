package nl.novi.loahy_v3.services;


import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.exceptions.RecordNotFoundException;
import nl.novi.loahy_v3.exceptions.UserEmailAlreadyExistException;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Authority;
import nl.novi.loahy_v3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userEmail) {
        if (!userRepository.existsById(userEmail)) {
            throw new RecordNotFoundException("User met email bestaat niet" );
        }
        UserDto userDto = userService.getByUserEmail(userEmail);
        Optional<User> user = userRepository.findUserByUserEmailIs(userEmail);

        String password = user.get().getPassword();

        Set<Authority> authorities = userDto.getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority: authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getAuthority()));
        }

        return new org.springframework.security.core.userdetails.User(userEmail, password, grantedAuthorities);
    }

}