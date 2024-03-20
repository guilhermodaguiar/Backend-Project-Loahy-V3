package nl.loahy_v3.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
public class OrderInputDto implements Serializable {

    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    @NotEmpty(message = "product list must not be empty")
    private List<Object> productList;
    private String comment;

    @NotEmpty(message = "order date must not be empty")
    private String orderDate;

    @Email(message = "invalid email address")
    private String email;

    @NotNull(message = "address must not be null")
    private Long addressId;
}
