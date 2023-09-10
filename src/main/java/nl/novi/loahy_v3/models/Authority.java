package nl.novi.loahy_v3.models;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@IdClass(AuthorityKey.class)
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    @Column(nullable = false)
    private String userEmail;

    @Id
    @Column(nullable = false)
    private String authority;

    public Authority() {}
    public Authority(String userEmail, String authority) {
        this.userEmail = userEmail;
        this.authority = authority;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}