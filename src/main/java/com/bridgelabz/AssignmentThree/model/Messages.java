package com.bridgelabz.AssignmentThree.model;

import com.bridgelabz.AssignmentThree.dto.MessageDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jdk.jfr.Enabled;

@Entity
public class Messages {

    @Id
    @GeneratedValue
    private long id;
    private String message;


    //////////////////// ::  Parameterised Constructor  :: ////////////////////
    public Messages(MessageDTO messageDTO) {

        this.message = "Hello " + messageDTO.firstName + " " + messageDTO.lastName +" !!";
    }

    public Messages(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public Messages() {
    }

    //////////////////// ::  Getter & Setter  :: ////////////////////
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Messages :: {" +'\n'+
                "id = " + id +
                "  ||   message = '" + message + '\n' +
                '}';
    }
}
