package com.api.messages_email.services;

import com.api.messages_email.components.MessageSender;
import com.api.messages_email.models.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final List<MessageSender> messageSenders;

    public void sendMessage(MessageRequest request) {
        MessageSender messageSender = messageSenders.stream()
                .filter(sender -> sender.getChannelType().equals(request.channel()))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Unsupported channel: " + request.channel()));

        messageSender.send(request);
    }
}
