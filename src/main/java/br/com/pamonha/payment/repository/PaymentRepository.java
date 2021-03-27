package br.com.pamonha.payment.repository;

import br.com.pamonha.payment.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    Optional<PaymentEntity> findByCheckoutCode(String checkoutCode);
}