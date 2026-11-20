package com.workflow.domain;

public abstract class Task  {

    private final String id;
    private final String name;

    private TaskStatus status;

    public Task(String id, String name){
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

    public void start(){

        if(status != TaskStatus.CREATED && status != TaskStatus.QUEUED){

            throw new IllegalStateException("Task cant start from status: " + status);
        }

        this.status=TaskStatus.RUNNING;
    }

    public void complete(){

        if(status!= TaskStatus.RUNNING){
            throw new IllegalStateException("Task cannot complete from status: " + status);
        }

        this.status= TaskStatus.COMPLETED;
    }

    public void fail(){

        if(status != TaskStatus.RUNNING){
            throw new IllegalStateException("Task cant fail from status: " + status);
        }

        this.status = TaskStatus.FAILED;
    }

    public void cancel(){

        if (status == TaskStatus.COMPLETED ||
                status == TaskStatus.FAILED ||
                status == TaskStatus.CANCELLED){

            throw new IllegalStateException("Task cannot be canceled from the status: " + status);
        }
        this.status=TaskStatus.CANCELLED;
    }
    public abstract void execute();
}
