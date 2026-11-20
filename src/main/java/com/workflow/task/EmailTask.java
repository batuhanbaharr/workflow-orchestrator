package com.workflow.task;

import com.workflow.domain.Task;

public class EmailTask extends Task {

    public EmailTask(String id, String name){
        super(id, name);
    }

    @Override
    public void execute(){

        System.out.println("Sending email: " + getName());

    }
}
