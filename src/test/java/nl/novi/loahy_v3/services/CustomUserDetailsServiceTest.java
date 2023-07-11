package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.models.Authority;
import nl.novi.loahy_v3.models.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
class CustomUserDetailServiceTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

//    @Test
//    @DisplayName("Should throw UsernameNotFoundException when user is not found")
//    void loadUserByUsernameWhenUserIsNotFoundThenThrowUsernameNotFoundException() {
//        when(userService.getByUserEmail(anyString())).thenReturn();
//
//        assertThrows(
//                UsernameNotFoundException.class,
//                () -> customUserDetailsService.loadUserByUsername("username"));
//    }

//    @Test
//    @DisplayName("Should return UserDetails when user is found")
//    void loadUserByUsernameWhenUserIsFoundThenReturnUserDetails() {
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
//
//        User user = new User();
//        user.setUserEmail("test");
//        user.setPassword("test");
//        user.addAuthority(new Authority("test", "ROLE_USER"));
//
//
//        when(userService.getByUserEmail(anyString())).thenReturn(UserDto.fromUser(user));
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername("test");
//
//        assertEquals("test", userDetails.getUsername());
//        assertEquals("test", userDetails.getPassword());
//        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER")));
//    }
}