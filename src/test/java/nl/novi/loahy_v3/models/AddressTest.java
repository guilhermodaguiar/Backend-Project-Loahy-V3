package nl.novi.loahy_v3.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressTest {

    @Test
    @DisplayName("Should set the zipcode")
    void setZipcodeShouldSetTheZipcode() {
        Address address = new Address();
        address.setZipcode("1234");
        assertEquals("1234", address.getZipcode());
    }

    @Test
    @DisplayName("Should return the zipcode of the user")
    void getPersonZipcodeShouldReturnTheZipcodeOfThePerson() {
        Address address = new Address();
        address.setZipcode("1234");
        assertEquals("1234", address.getZipcode());
    }

    @Test
    @DisplayName("Should set the city")
    void setCityShouldSetTheCity() {
        Address address = new Address();
        address.setCity("Rotterdam");
        assertEquals("Rotterdam", address.getCity());
    }

    @Test
    @DisplayName("Should return the city of the person")
    void getPersonCityShouldReturnTheCityOfThePerson() {
        Address address = new Address();
        address.setCity("Rotterdam");
        assertEquals("Rotterdam", address.getCity());
    }

    @Test
    @DisplayName("Should set the houseNumberAddition")
    void setHouseNumberAdd() {
        Address address = new Address();
        address.setHouseNumberAddition("A");
        assertEquals("A", address.getHouseNumberAddition());
    }

    @Test
    @DisplayName("Should return the houseNumberAdd")
    void gethouseNumberAddShouldReturnTheHouseNumberAdd() {
        Address address = new Address();
        address.setHouseNumberAddition("A");
        assertEquals("A", address.getHouseNumberAddition());
    }

    @Test
    @DisplayName("Should set the houseNumber")
    void setHouseNumber() {
        Address address = new Address();
        address.setHouseNumber("1");
        assertEquals("1", address.getHouseNumber());
    }

    @Test
    @DisplayName("Should return the house number")
    void getHouseNumberShouldReturnTheHouseNumber() {
        Address address = new Address();
        address.setHouseNumber("1");
        assertEquals("1", address.getHouseNumber());
    }

    @Test
    @DisplayName("Should set the streetName")
    void setStreetName() {
        Address address = new Address();
        address.setStreetName("test");
        assertEquals("test", address.getStreetName());
    }

    @Test
    @DisplayName("Should return the street name")
    void getStreetNameShouldReturnTheStreetName() {
        Address address = new Address();
        address.setStreetName("TestStreet");
        assertEquals("TestStreet", address.getStreetName());
    }

    @Test
    @DisplayName("Should set the phoneNumber")
    void setPhoneNumberShouldSetThePhoneNumber() {
        Address address = new Address();
        address.setPhoneNumber(1L);
        assertEquals(1L, address.getPhoneNumber());
    }

    @Test
    @DisplayName("Should return the phone number")
    void getPhoneNumberShouldReturnThePhoneNumber() {
        Address address = new Address();
        address.setPhoneNumber(1L);
        assertEquals(1L, address.getPhoneNumber());
    }


    @Test
    @DisplayName("Should set the address id")
    void setIdShouldSetTheAddressId() {
        Address address = new Address();
        address.setAddressId(1L);
        assertEquals(1L, address.getAddressId());
    }

    @Test
    @DisplayName("Should return the address id")
    void getAddressIdShouldReturnTheIdOfTheAddress() {
        Address address = new Address();
        address.setAddressId(1L);
        assertEquals(1L, address.getAddressId());
    }
}
