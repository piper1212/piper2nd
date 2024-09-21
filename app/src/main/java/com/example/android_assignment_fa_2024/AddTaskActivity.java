package com.example.android_assignment_fa_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class AddTaskActivity extends AppCompatActivity {
    private List<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        // TODO 6: Assign respective EditText and button to XML bindings
        // HINT: look at the error messages below to see what you should name the different entities

        // DO NOT MODIFY
        btnSubmitTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = taskDescription.getText().toString().trim();
                if (!description.isEmpty()) {
                    Task task = new Task(description);
                    TaskManagerSingleton.getInstance().addTask(task);
                    Intent intent = new Intent(AddTaskActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
