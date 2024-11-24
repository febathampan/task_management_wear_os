package com.appforall.androidweartaskmanagementapp.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.appforall.androidweartaskmanagementapp.databinding.ActivityMainBinding;
import com.appforall.androidweartaskmanagementapp.model.Task;
import com.appforall.androidweartaskmanagementapp.utils.TaskUtils;

import java.util.Calendar;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);
        init();
    }

    private void init() {
        mainBinding.btnSave.setOnClickListener(this);
        mainBinding.btnDateTime.setOnClickListener(this);
        mainBinding.btnListAll.setOnClickListener(this);
        //initTask();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == mainBinding.btnDateTime.getId()) {
            showDatePicker();
        }
        if (v.getId() == mainBinding.btnSave.getId()) {
            saveToSharedPref();
        }
        if (v.getId() == mainBinding.btnListAll.getId()) {
            showListing();
        }
    }

    private void showListing() {
        startActivity(new Intent(this, TasksActivity.class));
    }

    private void saveToSharedPref() {
        Task task = new Task(UUID.randomUUID().toString(), mainBinding.edtName.getText().toString(),
                mainBinding.edtTasker.getText().toString(), mainBinding.txtSelectedDT.getText().toString());
        TaskUtils.saveTask(task, this);
        clearAllFields();

    }

    private void clearAllFields() {
        mainBinding.edtTasker.setText("");
        mainBinding.edtName.setText("");
        mainBinding.txtSelectedDT.setText("");
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();

        // Show Date Picker
        new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
            calendar.set(year, month, dayOfMonth);

            // Show Time Picker after Date Picker
            new TimePickerDialog(this, (timeView, hourOfDay, minute) -> {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);

                // Format and display the selected date and time
                String dateTime = dayOfMonth + "/" + (month + 1) + "/" + year +
                        " " + String.format("%02d:%02d", hourOfDay, minute);
                mainBinding.txtSelectedDT.setText(dateTime);
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();

        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}