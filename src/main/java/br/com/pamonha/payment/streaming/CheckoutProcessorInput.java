package br.com.pamonha.payment.streaming;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CheckoutProcessorInput {
    String INPUT = "checkout-created-input";

    @Input(INPUT)
    SubscribableChannel input();
}

