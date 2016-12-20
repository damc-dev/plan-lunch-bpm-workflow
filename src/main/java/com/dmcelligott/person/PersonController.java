package com.dmcelligott.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by David on 12/19/2016.
 */
@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Person> findAllPerson() {
        return  personRepository.findAll();
    }

    @RequestMapping(value="/register", method=RequestMethod.POST, produces =  MediaType.APPLICATION_JSON_VALUE)
    public void registerPerson(@RequestBody Person person) {
        personRepository.save(person);
    }

    @RequestMapping(value="/unregister", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void unregisterPerson(@RequestParam Long id) {
        personRepository.delete(id);
    }


}
