package com.api.messages_email.components;

import com.api.messages_email.enums.ChannelType;
import com.api.messages_email.models.MessageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailComponent implements MessageSender {

    private final JavaMailSender mailSender;

    private static final String MESSAGE = "Alerta para preços de ações.";

    @Override
    public ChannelType getChannelType() {
        return ChannelType.EMAIL;
    }

    @Override
    public void send(MessageRequest request) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(request.to());
        mailMessage.setSubject(request.templateName() != null ? request.templateName() : MESSAGE);
        mailMessage.setText(request.message());
        mailSender.send(mailMessage);

        log.info("Email sent successfully to email address {} ", request.to());
    }
}
