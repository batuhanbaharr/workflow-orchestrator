package com.workflow.domain;

import java.util.ArrayList;
import java.util.List;

public class Workflow {

    private final String name;
    private final String id;
    private WorkflowStatus status;
    private final List<Task> tasks;

    public Workflow(String id, String name){
        this.id = id;
        this.name = name;
        this.status = WorkflowStatus.CREATED;
        this.tasks = new ArrayList<>();
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public WorkflowStatus getStatus() {
        return status;
    }

    public List<Task> getTasks(){
        return List.copyOf(tasks);
    }

    public void addTask(Task task){

        if(task == null){
            throw new IllegalArgumentException("Task cannot be null");
        }
        boolean taskAlreadyExist = tasks.stream().anyMatch(anyTaskInTheListTasks ->
                anyTaskInTheListTasks.getId().equals(task));

        if(taskAlreadyExist){
            throw new IllegalArgumentException("Task with this ID already exist:" + task.getId());
        }
        tasks.add(task);
    }
}
