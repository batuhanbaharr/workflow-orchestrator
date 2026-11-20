package com.workflow;

import com.workflow.domain.Workflow;
import com.workflow.domain.WorkflowStatus;
import org.junit.jupiter.api.Test;
import com.workflow.task.HttpTask;
import static org.junit.jupiter.api.Assertions.*;

public class WorkflowTest {

    @Test
    void newWorkflowShouldHaveCreatedStatus() {
        Workflow workflow = new Workflow("workflow-001", "User Registration");
        assertEquals(WorkflowStatus.CREATED, workflow.getStatus());
    }

    @Test
    void newWorkflowShouldHaveEmptyTaskList() {
        Workflow workflow = new Workflow("workflow-001", "User Registration");
        assertTrue(workflow.getTasks().isEmpty());
    }

    @Test
    void shouldAddTaskToWorkflow() {
        Workflow workflow = new Workflow("workflow-001", "User Registration");

        HttpTask task = new HttpTask("task-001", "Validate User");

        workflow.addTask(task);

        assertEquals(1, workflow.getTasks().size());
        assertEquals(task, workflow.getTasks().get(0));
    }

    @Test
    void shouldNotAllowDuplicateTaskIds() {

        Workflow workflow = new Workflow("workflow-001", "User Registration");

        HttpTask task1 = new HttpTask("task-001", "Validate User");

        HttpTask task2 = new HttpTask("task-001", "Create Account");

        workflow.addTask(task1);

        assertThrows(IllegalArgumentException.class, () -> workflow.addTask(task2));
    }

    @Test
    void shouldNotAllowNullTask() {

        Workflow workflow = new Workflow("workflow-001", "User Registration");

        assertThrows(IllegalArgumentException.class, () -> workflow.addTask(null));
    }

    @Test
    void shouldNotAllowExternalModificationOfTaskList() {

        Workflow workflow = new Workflow("workflow-001", "User Registration");

        HttpTask task = new HttpTask("task-001", "Validate User");

        workflow.addTask(task);

        assertThrows(UnsupportedOperationException.class, () -> workflow.getTasks().clear());
    }

}
