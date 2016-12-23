package com.dmcelligott.process;

import com.dmcelligott.meeting.MeetingRepository;
import com.dmcelligott.person.PersonRepository;
import com.dmcelligott.meeting.Meeting;
import com.dmcelligott.person.Person;
import com.dmcelligott.invitation.InvitationService;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by David on 12/19/2016.
 */
@RestController
public class ProcessController {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private InvitationService invitationService;


    @RequestMapping(value="/plan-lunch", method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void startPlanLunchProcess() {
        Meeting meeting = new Meeting();
        meeting.setLocation("Pepper Jacks");
        meeting.setStartTime(new Date());
        meetingRepository.save(meeting);

        invitationService.sendInvitations(meeting, personRepository.findAll());

        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("meeting", meeting);
        variables.put("location", meeting.getLocation());

        runtimeService.startProcessInstanceByKey("sendLunchInvitations", variables);
    }
}
