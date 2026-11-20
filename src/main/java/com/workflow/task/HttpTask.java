package com.workflow.task;

import com.workflow.domain.Task;

public class HttpTask extends Task {

    public HttpTask(String name, String id){
        super(name,id);
    }

    @Override
    public void execute(){

        System.out.println("Executing HTTP Request: " + getName());
    }
}
