package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;


    @InjectMocks
    private UserService userService;


    @Test
    @DisplayName("Should save the person when the person is not taken")
    void saveUserWhenUserIsNotTaken() {

        UserDto userDto = new UserDto();
        userDto.setUserEmail("test@gmail.com");

        userDto.setPassword("test");
        userDto.setEnabled(true);
        userDto.setFirstName("test");
        userDto.setLastName("test");
    }

}
