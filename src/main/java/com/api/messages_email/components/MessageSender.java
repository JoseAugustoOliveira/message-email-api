package com.api.messages_email.components;

import com.api.messages_email.enums.ChannelType;
import com.api.messages_email.models.MessageRequest;

public interface MessageSender {
    ChannelType getChannelType();
    void send(MessageRequest request);
}