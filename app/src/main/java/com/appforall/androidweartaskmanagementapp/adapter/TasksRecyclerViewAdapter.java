package com.appforall.androidweartaskmanagementapp.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appforall.androidweartaskmanagementapp.databinding.TaskRowBinding;
import com.appforall.androidweartaskmanagementapp.model.Task;

import java.util.List;

public class TasksRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Task> mTaskList;
    Context context;
    TaskRowBinding rowBinding;

    public TasksRecyclerViewAdapter(List<Task> mTasks, Context context) {
        super();
        this.mTaskList = mTasks;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        rowBinding = TaskRowBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(rowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bindView(mTaskList.get(position).getId(), mTaskList.get(position).getTaskName(), mTaskList.get(position).getTasker(), mTaskList.get(position).getDue());
    }

    @Override
    public int getItemCount() {
        return mTaskList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TaskRowBinding recyclerRowBinding;

        public ViewHolder(TaskRowBinding taskRowBinding) {
            super(taskRowBinding.getRoot());
            this.recyclerRowBinding = taskRowBinding;
        }

        public void bindView(final String id, final String name, final String tasker, final String due) {
            recyclerRowBinding.txtRwId.setText(id);
            recyclerRowBinding.txtRwName.setText(name);
            recyclerRowBinding.txtRwDue.setText(due);
            recyclerRowBinding.txtRwTasker.setText(tasker);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, TasksActivity.class);
                    intent.putExtra("CONTACT_ID", mTaskList.get(position).getId());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });*/
        }
    }
}