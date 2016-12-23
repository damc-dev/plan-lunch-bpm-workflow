package com.dmcelligott.process.task;

import com.dmcelligott.person.Person;
import org.springframework.stereotype.Component;

/**
 * Created by David on 12/20/2016.
 */
@Component
public class InvitationTask {
    public void sendInvitation(Person person) {
        System.out.println("Sent invitation to " + person.getName());
    }
}
