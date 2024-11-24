package com.appforall.androidweartaskmanagementapp.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.appforall.androidweartaskmanagementapp.R;
import com.appforall.androidweartaskmanagementapp.databinding.ActivityMainBinding;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view= mainBinding.getRoot();
        setContentView(view);
        init();
    }
    private void init(){
        mainBinding.btnSave.setOnClickListener(this);
        mainBinding.btnDateTime.setOnClickListener(this);
        mainBinding.btnListAll.setOnClickListener(this);
        //initTask();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == mainBinding.btnDateTime.getId()){
            showDatePicker();
        }
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