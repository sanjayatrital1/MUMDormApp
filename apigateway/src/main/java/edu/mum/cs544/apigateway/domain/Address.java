package edu.mum.cs544.apigateway.domain;

import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotEmpty;


public class Address {
    private Long aid;
    @SafeHtml
    @NotEmpty
    private String address;

    @NumberFormat(pattern = "###")
    private Long dormNumber;
    @NumberFormat(pattern = "###")
    private Long roomNumber;

    public Address() {
    }

    public Address(String address, Long dormNumber, Long roomNumber) {
        this.address = address;
        this.dormNumber = dormNumber;
        this.roomNumber = roomNumber;
    }

    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getDormNumber() {
        return dormNumber;
    }

    public void setDormNumber(Long dormNumber) {
        this.dormNumber = dormNumber;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }
}
