package com.workflow.domain;

public abstract class Task  {

    private final String id;
    private final String name;

    private TaskStatus status;

    public Task(String name, String id){
        this.id=id;
        this.name=name;
        this.status=TaskStatus.CREATED;

    }
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public TaskStatus getStatus(){
        return status;
    }
    public abstract void execute();
}
