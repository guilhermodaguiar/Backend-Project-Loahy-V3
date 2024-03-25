package nl.loahy_v3.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@IdClass(AuthorityKey.class)
@Table(name = "authorities")
public class Authority implements Serializable {

    @Id
    @Column(nullable = false)
    private String email;

    @Id
    @Column(nullable = false)
    private String authority;

    public Authority() {}
    public Authority(String email, String authority) {
        this.email = email;
        this.authority = authority;
    }

    public void setUsername(String email) {
        this.email = email;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}