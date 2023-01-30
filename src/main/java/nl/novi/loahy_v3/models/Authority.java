package nl.novi.loahy_v3.models;

import javax.persistence.*;
import java.io.Serializable;

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

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getAuthority() {
        return authority;
    }
    public void setAuthority(String authority) {
        this.authority = authority;
    }

}