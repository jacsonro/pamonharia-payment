package br.com.pamonha.payment.config;

import br.com.pamonha.payment.streaming.CheckoutProcessorInput;
import br.com.pamonha.payment.streaming.CheckoutProcessorOutput;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {CheckoutProcessorInput.class, CheckoutProcessorOutput.class})

public class StreamingConfig {
}