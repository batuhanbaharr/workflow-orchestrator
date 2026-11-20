package com.workflow.task;

import com.workflow.domain.Task;

public class HttpTask extends Task {

    public HttpTask(String id, String name){
        super(id, name);
    }

    @Override
    public void execute(){

        System.out.println("Executing HTTP Request: " + getName());
    }
}
