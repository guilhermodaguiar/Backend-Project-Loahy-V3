package nl.loahy_v3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }


    @Test
    @DisplayName("Should return the email of the user")
    void getEmailShouldReturnTheEmailOfTheUser() {
        user.setEmail("test@test.com");
        assertEquals("test@test.com", user.getEmail());
    }

    @Test
    @DisplayName("Should set the email")
    void setEmail() {
        user.setEmail("test@test.nl");
        assertEquals("test@test.nl", user.getEmail());
    }

    @Test
    @DisplayName("Should return the address when the address exists")
    void getAddressWhenAddressExists() {
        Address address = new Address();
        user.setAddress(address);
        assertEquals(address, user.getAddress());
    }

    @Test
    @DisplayName("Should return null when the address does not exist")
    void getAddressWhenAddressDoesNotExistThenReturnNull() {
        assertNull(user.getAddress());
    }

    @Test
    @DisplayName("Should set the address")
    void setAddress() {
        Address address = new Address();
        user.setAddress(address);
        assertEquals(address, user.getAddress());
    }

    @Test
    @DisplayName("Should return the authorities of the user")
    void getAuthoritiesShouldReturnAuthoritiesOfUser() {
        Authority authority = new Authority("email", "authority");
        user.addAuthority(authority);
        assertEquals(user.getAuthorities(), Set.of(authority));
    }

    @Test
    @DisplayName("Should add the authority to the authorities set")
    void addAuthorityShouldAddTheAuthorityToTheAuthoritiesSet() {
        Authority authority = new Authority("email", "authority");
        user.addAuthority(authority);
        assertTrue(user.getAuthorities().contains(authority));
    }

    @Test
    @DisplayName("Should remove the authority from the user")
    void removeAuthorityShouldRemovesTheAuthorityFromTheUser() {
        Authority authority = new Authority("email", "authority");
        user.addAuthority(authority);
        user.removeAuthority(authority);
        assertFalse(user.getAuthorities().contains(authority));
    }

    @Test
    @DisplayName("Should return the userId of the user")
    void getIdShouldReturnTheIdOfTheUser() {
        Long userId = 1L;
        user.setUserId(userId);
        assertEquals(userId, user.getUserId());
    }

    @Test
    @DisplayName("Should set the userId")
    void setId() {
        user.setUserId(1L);
        assertEquals(1L, user.getUserId());
    }
}

