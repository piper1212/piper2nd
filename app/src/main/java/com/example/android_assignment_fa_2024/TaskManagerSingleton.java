package com.example.android_assignment_fa_2024;
import java.util.ArrayList;
import java.util.List;
public class TaskManagerSingleton {
    private static TaskManagerSingleton instance;
    private List<Task> tasks;

    // DO NOT MODIFY!
    private TaskManagerSingleton() {
        tasks = new ArrayList<>();
    }

    // DO NOT MODIFY!
    public static TaskManagerSingleton getInstance() {
        if (instance == null) {
            instance = new TaskManagerSingleton();
        }
        return instance;
    }

    // TODO 2: Implement addTask functionality
    // HINT: look at the data structure type!
    public void addTask(Task task) {
        // CODE HERE
    }
    public List<Task> getTasks() {
        return tasks;
    }

}
