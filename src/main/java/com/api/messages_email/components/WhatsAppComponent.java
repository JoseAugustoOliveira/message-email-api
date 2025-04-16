package com.api.messages_email.components;

import com.api.messages_email.enums.ChannelType;
import com.api.messages_email.models.MessageRequest;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class WhatsAppComponent implements MessageSender {

    @Value("${twilio.account-sid}")
    private String accountSid;

    @Value("${twilio.auth-token}")
    private String authToken;

    @Value("${twilio.from-number}")
    private String fromNumber;

    @Override
    public ChannelType getChannelType() {
        return ChannelType.WHATS_APP;
    }

    @Override
    public void send(MessageRequest request) {
        Twilio.init(accountSid, authToken);
        Message.creator(
                new PhoneNumber("whatsapp:" + request.to()),
                new PhoneNumber("whatsapp:" + fromNumber),
                request.message()
        ).create();

        log.info("Whatsapp message sent successfully to {}", request.to());
    }
}
