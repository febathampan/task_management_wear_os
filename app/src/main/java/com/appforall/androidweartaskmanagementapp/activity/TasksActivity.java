package com.appforall.androidweartaskmanagementapp.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.appforall.androidweartaskmanagementapp.adapter.TasksRecyclerViewAdapter;
import com.appforall.androidweartaskmanagementapp.databinding.ActivityTasksBinding;
import com.appforall.androidweartaskmanagementapp.model.Task;
import com.appforall.androidweartaskmanagementapp.utils.TaskUtils;

import java.util.List;

public class TasksActivity extends AppCompatActivity {

    ActivityTasksBinding tasksBinding;

    private TasksRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tasksBinding = ActivityTasksBinding.inflate(getLayoutInflater());
        View view = tasksBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init() {

        showTasks();
        // Enable the back button in the ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void showTasks() {
        // Retrieve tasks from shared preferences
        List<Task> taskList = TaskUtils.getAllTasks(this);
        bindAdapter(taskList);

    }

    private void bindAdapter(List<Task> taskList) {
        mAdapter = new TasksRecyclerViewAdapter(taskList, this);
        tasksBinding.wrcTasks.setLayoutManager(new LinearLayoutManager(this)); // Ensure LayoutManager is set
        tasksBinding.wrcTasks.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }


    /**
     * Enables go back to previous page functionality
     *
     * @return
     */
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}