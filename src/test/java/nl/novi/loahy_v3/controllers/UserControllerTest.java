package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.dtos.UserPasswordOnlyDto;
import nl.novi.loahy_v3.models.User;
import nl.novi.loahy_v3.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;


    @InjectMocks
    private UserController userController;

    @Test
    @DisplayName("Should create a user when user does not exist")
    void createUserWhenUserDoesNotExist() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        UserDto user = new UserDto();
        user.setUserEmail("test@test.nl");
        user.setPassword("test123!");

        user.setFirstName("test");
        user.setLastName("test");


        ResponseEntity<UserDto> response = userController.createUser(user);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @DisplayName("Should delete the user when the id is valid")
    void deleteUserWhenIdIsValid() {
        User user = new User();
        user.setEmail("test@test.nl");
        user.setPassword("test123!");

        user.setFirstName("test");
        user.setLastName("test");


        userService.deleteUser("test@test.nl");

        verify(userService, times(1)).deleteUser("test@test.nl");
    }

    @Test
    @DisplayName("Should update password the user when the id is valid")
    void PatchUserWhenIdIsValid() {
        User user = new User();
        user.setEmail("test@test.nl");
        user.setPassword("test123!");

        user.setFirstName("test");
        user.setLastName("test");

        UserPasswordOnlyDto userPasswordOnlyDto = new UserPasswordOnlyDto();
        userPasswordOnlyDto.setPassword("newPasswordOnly!");

        ResponseEntity<?> response = userController.partialUpdateUserPassword("test@test.nl", userPasswordOnlyDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
