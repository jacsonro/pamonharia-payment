package br.com.pamonha.payment.service;

import br.com.pamonha.checkout.event.CheckoutCreatedEvent;
import br.com.pamonha.payment.entity.PaymentEntity;

import java.util.Optional;

public interface PaymentService {

    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
    boolean exist(CheckoutCreatedEvent checkoutCreatedEvent);
    //Optional<PaymentEntity> updateStatus(String checkoutCode, PaymentEntity.Status status);

}