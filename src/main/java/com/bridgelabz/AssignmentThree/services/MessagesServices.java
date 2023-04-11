package com.bridgelabz.AssignmentThree.services;

import com.bridgelabz.AssignmentThree.model.Messages;
import com.bridgelabz.AssignmentThree.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessagesServices{
    private static final String template = "Hello World";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private MessageRepo repository;

    public Messages greetingMessages() {
        return new Messages(counter.incrementAndGet(),template);
    }


    public String greetingMessagesTwo(String firstName, String lastName) {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return "Hello World !!";
        } else if (lastName.isEmpty()) {
            return "Hello " + firstName ;
        } else if (firstName.isEmpty()) {
            return "Hello " + lastName ;
        }
        return "Hello " + firstName +" "+ lastName ;
    }

    public Messages greetingMessagesThree(Messages message){
        Messages userMessage = new Messages(message.getId(), message.getMessage());
        return repository.save(message);
    }
}