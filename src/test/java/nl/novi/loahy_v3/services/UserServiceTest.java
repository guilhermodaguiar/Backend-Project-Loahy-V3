package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.models.User;
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

        User user = new User();
        user.setUserEmail("test@gmail.com");

        user.setPassword("test");
        user.setEnabled(true);
        user.setFirstName("test");
        user.setLastName("test");
    }

}
