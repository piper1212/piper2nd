package com.example.android_assignment_fa_2024;
// DO NOT MODIFY THIS CLASS
public class Task {
    private String task;
    private boolean isCompleted;

    public Task(String task) {
        this.task = task;
        this.isCompleted = false;
    }

    public String getDescription() {
        return task;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompletionStatus( boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

}
