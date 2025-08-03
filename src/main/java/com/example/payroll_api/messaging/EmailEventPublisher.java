package com.example.payroll_api.messaging;

import com.example.payroll_api.model.EmailRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public EmailEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendEmailEvent(EmailRequest request) {
        rabbitTemplate.convertAndSend("email-exchange", "email.routing.key", request);
    }
}
