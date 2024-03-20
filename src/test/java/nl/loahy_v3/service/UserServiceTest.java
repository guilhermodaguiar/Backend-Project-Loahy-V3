package nl.loahy_v3.service;

import nl.loahy_v3.dto.UserDto;
import nl.loahy_v3.model.User;
import nl.loahy_v3.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Should return the user when the user exists")
    void getUserWhenUserExists() {
        User user = new User();

        user.setFirstName("Felipe");
        user.setLastName("IsDaBest");
        user.setEmail("Felipe@dabest.nl");
        user.setPassword("oldPassword!!");
        user.setUserId(1L);

        when(userRepository.findById("Felipe@dabest.nl")).thenReturn(Optional.of(user));

        UserDto userDto = userService.getUser("Felipe@dabest.nl");

        assertThat(userDto.email).isEqualTo(user.getEmail());
    }

    @Test
    @DisplayName("Should returns all users")
    void getUsersShouldReturnsAllUsers() {
        User user = new User();
        user.setUserId(1L);
        user.setEmail("test@test.nl");
        user.setPassword("test!!!");
        user.setFirstName("Test");
        user.setLastName("Test");

        when(userRepository.findAll()).thenReturn(List.of(user));

        List<UserDto> users = userService.getAllUsers();

        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertEquals(1, users.size());

        verify(userRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("Should throw an exception when the user does not exist")
    void getUserWhenUserDoesNotExistThenThrowException() {
        when(userRepository.findById("100")).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> userService.getUser("100"));

        verify(userRepository, times(1)).findById("100");
    }
}

