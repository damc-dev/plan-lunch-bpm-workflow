package com.dmcelligott.invitation;

import org.activiti.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by David on 12/19/2016.
 */
@RestController
@RequestMapping(value = "invitation")
public class InvitationController {
    private final Logger Logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private InvitationRepository invitationRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Invitation> findAllInvitations() {
        return invitationRepository.findAll();
    }

    @RequestMapping(value = "/respond", method = RequestMethod.GET)
    void respondInvitation(@RequestParam String response, @RequestParam long meetingId, @RequestParam long personId, @RequestParam String executionId) {
        Logger.info("Recieved invitation response: personId: {}, meetingId: {}, response: {}", personId, meetingId, response);
        List<Invitation> invitations = invitationRepository.findByMeetingIdAndPersonId(meetingId, personId);
        for(Invitation invitation : invitations) {
            if (response.toLowerCase().equals("accept")) {
                invitation.setGoing(true);
            } else {
                invitation.setGoing(false);
            }
            invitationRepository.save(invitation);
        }

            runtimeService.signal(executionId);
    }
}
