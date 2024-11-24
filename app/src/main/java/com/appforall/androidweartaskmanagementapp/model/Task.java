package com.appforall.androidweartaskmanagementapp.model;

public class Task {
    private String id;
    private String taskName;
    private String tasker;
    private String due;

    public Task(String id, String tasker, String taskName, String due) {

        this.due = due;
        this.id = id;
        this.tasker = tasker;
        this.taskName = taskName;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTasker() {
        return tasker;
    }

    public void setTasker(String tasker) {
        this.tasker = tasker;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
