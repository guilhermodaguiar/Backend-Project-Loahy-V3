package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Authority;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

import static com.fasterxml.jackson.databind.introspect.AnnotationMap.of;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {
    @Mock
    private UserService userService;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

//    @Test
//    @DisplayName("Should throw UsernameNotFoundException when user is not found")
//    void loadUserByUsernameWhenUserIsNotFoundThenThrowUsernameNotFoundException() {
//        when(userService.getByUserEmail(anyString()));
//
//        assertThrows(
//                UsernameNotFoundException.class,
//                () -> customUserDetailsService.loadUserByUsername("username"));
//    }
//
//    @Test
//    @DisplayName("Should return UserDetails when user is found")
//    void loadUserByUsernameWhenUserIsFoundThenReturnUserDetails() {
//        UserDto userDto = new UserDto();
//        User user = new User();
//
//        userDto.setFirstName("test");
//        userDto.setLastName("test");
//        userDto.setUserEmail("test");
//        user.setPassword("test");
//        user.addAuthority(new Authority("test", "ROLE_USER"));
//
//
//        when(userService.getByUserEmail(anyString())).thenReturn(Optional.of(userDto));
//
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername("test");
//
//        assertEquals("test", userDetails.getUsername());
//        assertEquals("test", userDetails.getPassword());
//        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
//    }
}
