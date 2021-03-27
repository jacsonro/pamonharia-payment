package br.com.pamonha.payment.service;

import br.com.pamonha.checkout.event.CheckoutCreatedEvent;
import br.com.pamonha.payment.entity.PaymentEntity;
import br.com.pamonha.payment.event.PaymentCreatedEvent;
import br.com.pamonha.payment.repository.PaymentRepository;
import br.com.pamonha.payment.streaming.CheckoutProcessorOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CheckoutServiceImpl implements CheckoutService {
    private final CheckoutProcessorOutput checkoutProcessorOutput;

    @Override
    public void output(PaymentCreatedEvent paymentCreatedEvent) {
        try {
            final MessageBuilder<PaymentCreatedEvent> paymentCreatedEventMessageBuilder = MessageBuilder.withPayload(paymentCreatedEvent);
            paymentCreatedEventMessageBuilder.setHeader("contentType", null);
            final Message<PaymentCreatedEvent> build = paymentCreatedEventMessageBuilder.build();
            checkoutProcessorOutput.output().send(build);
        }
        catch(Exception e) {
            log.info("Event_22={}", e.getCause());
        }

    }

}