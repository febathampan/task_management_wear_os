package com.appforall.androidweartaskmanagementapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.appforall.androidweartaskmanagementapp.model.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public static List<Task> getAllTasks(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("task_details", Context.MODE_PRIVATE);
        List<Task> taskList = new ArrayList<>();
        Map<String, ?> map = sharedPreferences.getAll();

        Set set = map.entrySet();
        Iterator itr = set.iterator();
        while (itr.hasNext()){
            Map.Entry entry = (Map.Entry) itr.next();
            String allData = (String) entry.getValue();
            String[] arr = allData.split("<");
            if(arr.length==3){ // or arrsize check
                Task t = new Task(entry.getKey().toString(), arr[0], arr[1], arr[2]);
                taskList.add(t);
            }
        }
        return taskList;
    }
}
