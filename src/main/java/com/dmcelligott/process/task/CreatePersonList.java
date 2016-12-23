package com.dmcelligott.process.task;

import com.dmcelligott.person.PersonRepository;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by David on 12/20/2016.
 */
@Component
public class CreatePersonList implements JavaDelegate {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        delegateExecution.setVariable("invitees", personRepository.findAll());
    }
}
