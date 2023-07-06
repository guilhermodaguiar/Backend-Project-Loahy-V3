package nl.novi.loahy_v3.dtos;


import nl.novi.loahy_v3.models.Address;


public class AddressInputDto {

    public Long addressId;

    public String streetName;

    public String houseNumber;
    public String houseNumberAddition;

    public String city;

    public String zipcode;

    public Long phoneNumber;


    public Address toAddress() {

        var address = new Address();

        address.setAddressId(addressId);
        address.setStreetName(streetName);
        address.setHouseNumber(houseNumber);
        address.setHouseNumberAddition(houseNumberAddition);
        address.setCity(city);
        address.setZipcode(zipcode);
        address.setPhoneNumber(phoneNumber);

        return address;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumberAddition() {
        return houseNumberAddition;
    }

    public void setHouseNumberAddition(String houseNumberAddition) {
        this.houseNumberAddition = houseNumberAddition;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
