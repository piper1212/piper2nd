package com.example.android_assignment_fa_2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> tasks;
    private LinearLayout taskContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // TODO 1: Set content view to activity_main.xml file


        // DO NOT MODIFY
        tasks = TaskManagerSingleton.getInstance().getTasks();
        taskContainer = findViewById(R.id.taskContainer);
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FloatingActionButton btnAddTask = findViewById(R.id.fab);







        // TODO 3: Program the btnAddTask to trigger an intent
        //  Intent should switch the activity on screen to AddTaskActivity when btnAddTask is clicked
        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // TODO 5: Iterate over all the tasks in the list and use the addTaskToUI helper method to add the description to the UI
        // CODE HERE

    }

    // DO NOT MODIFY METHOD
    // This method takes a SINGULAR task and automatically propagates it to the UI with a corresponding checkbox
    private void addTaskToUI(Task task) {
        LinearLayout taskItemLayout = new LinearLayout(this);
        taskItemLayout.setOrientation(LinearLayout.HORIZONTAL);
        taskItemLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        CheckBox checkBox = new CheckBox(this);
        checkBox.setChecked(task.isCompleted());
        // Set listener to update the task's isCompleted field
        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            task.setCompletionStatus(isChecked);
        });

        checkBox.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        TextView taskView = new TextView(this);
        taskView.setText(task.getDescription());
        taskView.setTextSize(16);
        taskView.setPadding(20, 20, 20, 20);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(
                0,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1.0f);
        taskView.setLayoutParams(textParams);

        taskItemLayout.addView(checkBox);
        taskItemLayout.addView(taskView);

        taskContainer.addView(taskItemLayout);
    }


}