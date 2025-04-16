package com.api.messages_email.models;

import com.api.messages_email.enums.ChannelType;
import lombok.Builder;

import java.util.Map;

@Builder
public record MessageRequest(
        String to,
        ChannelType channel,
        String message,
        String templateName,
        Map<String, String> templateVariables,
        Map<String, Object> attributes) {}
