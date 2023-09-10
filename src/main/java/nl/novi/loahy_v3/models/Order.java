package nl.novi.loahy_v3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "order_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "75"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Column
    private Long orderId;

    @Type(type = "json")
    private List<Object> productList;

    @Column
    private String comment;

    @Column
    public Long addressId;
    @Column
    public String orderDate;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User userEmail;

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setProductList(List<Object> productList) {
        this.productList = productList;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }


    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public void setUserEmail(User userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserEmail() {
    }

    public void setUserEmail(String test) {
    }
}
