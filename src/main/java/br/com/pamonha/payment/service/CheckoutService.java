package br.com.pamonha.payment.service;

import br.com.pamonha.payment.event.PaymentCreatedEvent;
import br.com.pamonha.payment.streaming.CheckoutProcessorOutput;

public interface CheckoutService {
     void output(PaymentCreatedEvent paymentCreatedEvent);
}