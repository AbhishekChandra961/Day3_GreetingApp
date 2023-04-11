package com.bridgelabz.AssignmentThree.services;

import com.bridgelabz.AssignmentThree.model.Messages;
import com.bridgelabz.AssignmentThree.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public String getMessagesById(long id){
        Optional<Messages> messageById = repository.findById(id);
        if(messageById.isPresent()){
            return "=>>  " + repository.findById(id);
        }
        return ":: ID doesn't Exist :: ";
    }

    public List<Messages> getAllMessagesInRepository(){
        return (List<Messages>) repository.findAll();
    }
    public String editGreetingMessage(Messages message, long id) {
        Optional<Messages> editMessage = repository.findById(id);
        if (editMessage.isPresent()) {
            editMessage.get().setMessage(message.getMessage());
            repository.save(editMessage.get());
            return "Message Edited Successfully" + message.getMessage();
        }
        else
            return " :: Message ID doesn't Exist ::";
    }
}