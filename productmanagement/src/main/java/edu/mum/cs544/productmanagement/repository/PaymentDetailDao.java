package edu.mum.cs544.productmanagement.repository;

import edu.mum.cs544.productmanagement.domain.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailDao extends JpaRepository<PaymentDetail, Long> {

}
