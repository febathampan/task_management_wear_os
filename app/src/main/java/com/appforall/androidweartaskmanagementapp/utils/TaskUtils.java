package com.appforall.androidweartaskmanagementapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.appforall.androidweartaskmanagementapp.model.Task;

public class TaskUtils {
    public static void saveTask(Task task, Context context) {
        if (task != null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("task_details", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            System.out.println("Plain: "+task.getDue());
            System.out.println("To String: "+ task.getDue());
            editor.putString(task.getId(), task.getTaskName()+ "<"+ task.getTasker() + "<"+ task.getDue().toString() );
            editor.commit();
            //If you want to track failure, write this in try catch block. On exception catch, write failureMethod
        }
    }
}
