package nl.novi.loahy_v3.controllers;

import nl.novi.loahy_v3.dtos.UserDto;
import nl.novi.loahy_v3.repositories.UserRepository;
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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    @Test@DisplayName("Should create a user when the user does not exist")
    void createUserWhenUserDoesNotExist() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        UserDto userDto = new UserDto();
        userDto.setUserEmail("test@test.nl");
        userDto.setPassword("test123!");

        userDto.setEnabled(true);
        userDto.setApikey("test");
        userDto.setFirstName("test");
        userDto.setLastName("test");


        ResponseEntity<UserDto> response = userController.createUser(userDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    @DisplayName("Should delete the user when the id is valid")
    void deleteUserWhenIdIsValid() {
        UserDto userDto = new UserDto();
        userDto.setUserEmail("test@test.nl");
        userDto.setPassword("test123!");

        userDto.setEnabled(true);
        userDto.setApikey("test");
        userDto.setFirstName("test");
        userDto.setLastName("test");


        userService.deleteUser("test@test.nl");

        verify(userService, times(1)).deleteUser("test@test.nl");
    }


    @Test
    @DisplayName("Should returns the user when email is valid")
    void getUserWhenUserEmailIsValid() {
        UserDto userDto = new UserDto();
        userDto.setUserEmail("Guily@test.nl");
        userDto.setPassword("test123!");

        userDto.setEnabled(true);
        userDto.setApikey("test");

        userDto.setFirstName("Guily");
        userDto.setLastName("Dagi");


        when(userService.getUser("Guily@test.nl")).thenReturn(userDto);

        UserDto result = userController.getUserByUserEmail(userDto.userEmail).getBody();

        assertNotNull(result);
        assertEquals("Guily@test.nl", result.userEmail);
        assertEquals("test123!", result.password);

        assertEquals(true, result.enabled);
        assertEquals("test", result.apikey);

        assertEquals("true", result.userEmail);
        assertEquals("Guily", result.firstName);
        assertEquals("Dagi", result.lastName);
    }


}
