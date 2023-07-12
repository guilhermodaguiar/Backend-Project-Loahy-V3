package nl.novi.loahy_v3.services;

import nl.novi.loahy_v3.dtos.UserPasswordOnlyDto;
import nl.novi.loahy_v3.models.Address;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.models.Wishlist;
import nl.novi.loahy_v3.repositories.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;


    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("Should update the password when the user exists")
    void updatePersonWhenPersonExists() {
        User user = new User();
        user.setUserId(1L);
        user.setUserEmail("test@test.nl");
        user.setFirstName("test");
        user.setLastName("test");
        user.setPassword("test!");
        user.setAddress(new Address());
        user.setWishlist(new Wishlist());


        when(userRepository.findById("test@test.nl")).thenReturn(Optional.of(user));

        UserPasswordOnlyDto dto = new UserPasswordOnlyDto();

        dto.setPassword("newPassword!");
        userService.updatePassword("test@test.nl", dto);

        verify(userRepository).save(user);

        assertThat(user.getUserEmail()).isEqualTo("test.test.nl");
        assertThat(user.getPassword()).isEqualTo("newPassword!");

    }
}

