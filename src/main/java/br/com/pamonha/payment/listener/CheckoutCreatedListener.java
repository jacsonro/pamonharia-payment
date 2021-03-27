package br.com.pamonha.payment.listener;


import br.com.pamonha.checkout.event.CheckoutCreatedEvent;
import br.com.pamonha.payment.entity.PaymentEntity;
import br.com.pamonha.payment.event.PaymentCreatedEvent;
import br.com.pamonha.payment.service.CheckoutService;
import br.com.pamonha.payment.service.PaymentService;
import br.com.pamonha.payment.streaming.CheckoutProcessorInput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import org.springframework.context.annotation.Scope;

@Component
@RequiredArgsConstructor
@Slf4j
public class CheckoutCreatedListener {
    private final PaymentService paymentService;
    private final CheckoutService checkoutService;

    @StreamListener(CheckoutProcessorInput.INPUT)
    public void handler(CheckoutCreatedEvent checkoutCreatedEvent){
        if (!paymentService.exist(checkoutCreatedEvent)) {
            log.info("Event_2={}", checkoutCreatedEvent.getCheckoutCode());
        final PaymentEntity paymentEntity = paymentService.create(checkoutCreatedEvent).orElseThrow();
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(paymentEntity.getCheckoutCode())
                .setPaymentCode(paymentEntity.getCode())
                .build();
            checkoutService.output(paymentCreatedEvent);
        }
    }
}
