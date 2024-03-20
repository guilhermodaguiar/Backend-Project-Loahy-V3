package nl.loahy_v3.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
public class AddressInputDto {

    @NotBlank(message = "street name description must not be blank")
    public String streetName;

    @NotBlank(message = "house number must not be blank")
    public String houseNumber;
    public String houseNumberAddition;

    @NotBlank(message = "city must not be blank")
    public String city;

    @NotBlank(message = "zipcode must not be blank")
    @Pattern(regexp = "^[1-9][0-9]{3} ?(?!sa|sd|ss|SA|SD|SS)[A-Za-z]{2}$", message = "zipcode must be in the form 1234AA")
    public String zipcode;

    @NotNull
    public Long phoneNumber;

}
