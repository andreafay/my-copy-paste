package dev.andreafay.my_copy_paste.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @Column(unique = true)
    private String email;

    private String name;

    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
