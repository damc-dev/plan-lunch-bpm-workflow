package com.dmcelligott.invitation;

import com.dmcelligott.meeting.Meeting;
import com.dmcelligott.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by David on 12/19/2016.
 */
@Component
public class InvitationService {

    @Autowired
    private InvitationRepository invitationRepository;

    public void sendInvitations(Meeting meeting, List<Person> invitees) {
        invitationRepository.save(invitees.stream().map( person -> new Invitation(meeting, person)).collect(Collectors.toList()));
    }
}
