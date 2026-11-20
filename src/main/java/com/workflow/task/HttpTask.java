package com.workflow.task;

import com.workflow.domain.Task;

public class HttpTask extends Task {

    public HttpTask(String name, String id){
        super(id, name);
    }

    @Override
    public void execute(){

        System.out.println("Executing HTTP Request: " + getName());
    }
}
