package com.api.messages_email.services;

import com.api.messages_email.components.MessageSender;
import com.api.messages_email.enums.ChannelType;
import com.api.messages_email.models.MessageRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final Map<ChannelType, MessageSender> messageSenderMap;

    public MessageService(List<MessageSender> messageSenderList) {
        this.messageSenderMap = messageSenderList.stream()
                .collect(Collectors.toMap(MessageSender::getChannelType, Function.identity()));
    }

    public void sendMessage(MessageRequest request) {
        MessageSender messageSender = messageSenderMap.get(request.channel());

        if (messageSender == null) {
            throw new IllegalArgumentException("Unsupported channel: " + request.channel());
        }

        messageSender.send(request);
    }
}
