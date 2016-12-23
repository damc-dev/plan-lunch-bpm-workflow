package com.dmcelligott.ui;

import com.dmcelligott.meeting.MeetingRepository;
import com.dmcelligott.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by David on 12/22/2016.
 */

@RestController
@RequestMapping(value = "ui")
public class UiController {

    @Autowired
    MeetingRepository meetingRepository;

    @RequestMapping(value="/event/{meetingId}", method= RequestMethod.GET)
    public ModelAndView viewEvent(@PathVariable("meetingId") long meetingId) {
        return new ModelAndView("/event", "event", meetingRepository.getOne(meetingId));
    }


}
