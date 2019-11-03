package com.example.hw1_android1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyTaskViewHolder> {

    List<Task> taskList;
    MainActivity mainActivity;
     public TaskAdapter(List<Task> mytasks,MainActivity mainActivity){
         this.taskList = mytasks;
         this.mainActivity=mainActivity;
     }


    @NonNull
    @Override
    public TaskAdapter.MyTaskViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_task,viewGroup,false);
         MyTaskViewHolder tvh=new MyTaskViewHolder(v);
        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.MyTaskViewHolder myTaskViewHolder, int i) {
        myTaskViewHolder.title.setText(taskList.get(i).title);
        myTaskViewHolder.context.setText((taskList.get(i).context));
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class MyTaskViewHolder extends RecyclerView.ViewHolder{
         TextView title;
         TextView context;
        public MyTaskViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.cardtasktitle);
            context=itemView.findViewById(R.id.cardtaskcontext);
        }
    }
}
