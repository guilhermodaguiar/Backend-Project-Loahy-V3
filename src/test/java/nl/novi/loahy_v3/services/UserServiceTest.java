package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
        user.setUserEmail("Felipe@dabest.nl");
        user.setPassword("oldPassword!!");
        user.setUserId(1L);

        when(userRepository.findById("Felipe@dabest.nl")).thenReturn(Optional.of(user));

        UserDto userDto = userService.getByUserEmail("Felipe@dabest.nl");

        assertThat(userDto.userEmail).isEqualTo(user.getUserEmail());
    }

    @Test
    @DisplayName("Should returns all users")
    void getUsersShouldReturnsAllUsers() {
        User user = new User();
        user.setUserId(1L);
        user.setUserEmail("test@test.nl");
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
}

