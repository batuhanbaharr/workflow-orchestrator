package com.workflow;

import com.workflow.domain.TaskStatus;
import com.workflow.task.HttpTask;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class HttpTaskTest {

    @Test
    void newTaskShouldHaveCreatedStatus(){

        HttpTask task = new HttpTask("task-001", "Send http request");
        assertEquals(TaskStatus.CREATED, task.getStatus());
    }
    @Test
    void taskShouldStartSuccessfully(){
        HttpTask task = new HttpTask("task-001", "Send http request");
        task.start();
        assertEquals(TaskStatus.RUNNING, task.getStatus());
    }
    @Test
    void taskShouldCompleteSuccessfully() {
        HttpTask task = new HttpTask("task-001", "HTTP Request");
        task.start();
        task.complete();
        assertEquals(TaskStatus.COMPLETED, task.getStatus());
    }
    @Test
    void taskShouldFailSuccessfully() {

        HttpTask task = new HttpTask("task-001", "HTTP Request");
        task.start();
        task.fail();
        assertEquals(TaskStatus.FAILED, task.getStatus());
    }

    @Test
    void taskShouldCancelSuccessfully() {
        HttpTask task = new HttpTask("task-001", "HTTP Request");
        task.cancel();
        assertEquals(TaskStatus.CANCELLED, task.getStatus());
    }

    @Test
    void completedTaskShouldNotBeCancelled() {

        HttpTask task = new HttpTask("task-001", "HTTP Request");
        task.start();
        task.complete();
        assertThrows(IllegalStateException.class, task::cancel);
    }

    @Test
    void taskShouldNotCompleteBeforeStarting() {
        HttpTask task = new HttpTask("task-001", "HTTP Request");
        assertThrows(IllegalStateException.class, task::complete);
    }



}
