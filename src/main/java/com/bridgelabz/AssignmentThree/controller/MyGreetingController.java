package com.bridgelabz.AssignmentThree.controller;

import com.bridgelabz.AssignmentThree.dto.MessageDTO;
import com.bridgelabz.AssignmentThree.model.Messages;
import com.bridgelabz.AssignmentThree.services.MessagesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greet")
public class MyGreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    //////////////////// ::  UC-01  :: ////////////////////
    @GetMapping(value = {"/hello","/home"})
    public Messages getMessageFromUser(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Messages(counter.incrementAndGet(), String.format(template,name));
    }

    @GetMapping("/{name}")
    public Messages greetings(@PathVariable String name) {
        return new Messages(counter.incrementAndGet(), String.format(template, name));
    }


    //////////////////// ::  UC-02  :: ////////////////////
    @Autowired
    private MessagesServices iServices;

    @GetMapping("/service")
    public Messages greeting() {
        return iServices.greetingMessages();
    }

    //////////////////// ::  UC-03  :: ////////////////////

    @GetMapping(value = {"/printname","/"})
    public String Messages(@RequestParam(value = "firstName", defaultValue = "") String firstName,
                           @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        return iServices.greetingMessagesTwo(firstName, lastName);
    }


    //////////////////// ::  UC-04  :: ////////////////////
    @PostMapping("/post")
    public String addGreeting(@RequestBody MessageDTO messageDTO){
        Messages message = new Messages(messageDTO);
        iServices.greetingMessagesThree(message);
        return "Saved Successfully!!!";
    }

    //////////////////// ::  UC-05  :: ////////////////////
    @GetMapping("/getMessage/{id}")
    public String getMessage(@PathVariable long id) {
        return iServices.getMessagesById(id);
    }

    //////////////////// ::  UC-06  :: ////////////////////
    @GetMapping("/getAllMessage")
    public List<Messages> getAllMessages(){
        return iServices.getAllMessagesInRepository();
    }
    @PutMapping("/editMessage/{id}")
    public String editId(@RequestBody MessageDTO messageDTO, @PathVariable long id){
        Messages message = new Messages(messageDTO);
        return iServices.editGreetingMessage(message,id);
    }
}