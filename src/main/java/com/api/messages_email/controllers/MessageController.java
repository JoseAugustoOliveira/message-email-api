package com.api.messages_email.controllers;

import com.api.messages_email.models.MessageRequest;
import com.api.messages_email.services.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Messages")
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    @Operation(summary = "Send message or email")
    public ResponseEntity<String> sendMessage(@RequestBody MessageRequest request) {
        messageService.sendMessage(request);
        return ResponseEntity.ok("Message sent successfully!");
    }
}


