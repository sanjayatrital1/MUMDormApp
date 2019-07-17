package edu.mum.cs544.apigateway.domain;


import lombok.Data;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class User {
    private Long uid;

    @SafeHtml
    @NotEmpty
    private String userName;

    @SafeHtml
    @NotNull
    @Email

    private String email;

    @NotNull
    private String password;

    private Address addr;

    public User() {
    }

//    public User(String email, String password){
//        this.email=email;
//        this.password=password;
//    }
//
//    public User(String userName, String email, String password) {
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }
}
