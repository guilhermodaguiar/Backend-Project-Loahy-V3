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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

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
    @DisplayName("Shoukd delete the user when the user exists")
    void deleteUserWhenUserExists() {
        User user = new User();

        user.setUserEmail("Felipe@dabest.nl");
        user.setFirstName("Felipe");
        user.setLastName("IsDaBest");



        userService.deleteUser("Felipe@dabest.nl");

        verify(userService, times(1)).deleteUser("Felipe@dabest.nl");
    }
}

