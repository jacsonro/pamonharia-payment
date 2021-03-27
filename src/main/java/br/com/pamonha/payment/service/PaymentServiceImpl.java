package br.com.pamonha.payment.service;

import br.com.pamonha.checkout.event.CheckoutCreatedEvent;
import br.com.pamonha.payment.entity.PaymentEntity;
import br.com.pamonha.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        final PaymentEntity paymentEntity = PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode().toString())
                .code(UUID.randomUUID().toString())
                .build();
        paymentRepository.save(paymentEntity);
        return Optional.of(paymentEntity);
    }
    public boolean exist(CheckoutCreatedEvent checkoutCreatedEvent){
        final Optional<PaymentEntity> paymentEntity = paymentRepository.findByCheckoutCode(checkoutCreatedEvent
                        .getCheckoutCode()
                        .toString());
        if(paymentEntity.isEmpty())
            return false;
        return true;
    }

    /*
    @Override
    public Optional<PaymentEntity> updateStatus(String checkoutCode, PaymentEntity.Status status) {
        final PaymentEntity paymentEntity = paymentRepository.findByCode(checkoutCode).orElse(PaymentEntity.builder().build());
        paymentEntity.setStatus(PaymentEntity.Status.APPROVED);
        return Optional.of(paymentRepository.save(paymentEntity));
    }
    */
}