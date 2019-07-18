package edu.mum.cs544.productmanagement.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
public class PaymentDetail {
    @Id
    @GeneratedValue
    Long id;
    String paymentId;
    String payerId;
    String payerName;
    String payerEmail;
    String shipAddLine1;
    String shipAddCity;
    String shipAddState;
    String shipAddPostalCode;
    String shipAddCountryCode;
    LocalDate payDate;
    Double amount;
    String remarks;
}