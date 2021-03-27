package br.com.pamonha.payment.streaming;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface CheckoutProcessorOutput {

    String OUTPUT = "payment-paid-output";

    @Output(OUTPUT)
    MessageChannel output();
}

