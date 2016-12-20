package com.dmcelligott.invitation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by David on 12/19/2016.
 */
@RestController
@RequestMapping(value = "invitation")
public class InvitationController {

    @Autowired
    private InvitationRepository invitationRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Invitation> findAllInvitations() {
        return invitationRepository.findAll();
    }
}
