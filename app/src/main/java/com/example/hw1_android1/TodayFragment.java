package com.example.hw1_android1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class TodayFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_today,container,false);


        List<Task> taskList =new ArrayList<>();
        taskList.add(new Task("title","context",false));
        taskList.add(new Task("title2","context4",false));
        taskList.add(new Task("title3","conteoaeirjfoauhrgaouro;rfrxt5",false));
        taskList.add(new Task("title","contaeiurgeiurgbaiuerbgaieurjv arei ahi arfa wefih  aweifh aweif aieh fa;kext",false));
        taskList.add(new Task("title2","oerhsdjf vlj/vl erlj erlj le rvl vljs rlj srl/vsj context4",false));
        taskList.add(new Task("title3","contne rvwjer wj fwjfwjr fj wlfj wjr ls.r erjk fskehr fs.kerh .sker ext5",false));
        taskList.add(new Task("title","co erkjes r.keh rvkes vke vkr vbkehr kk dfkvxc nmntext",false));
        taskList.add(new Task("title2","context4",false));
        taskList.add(new Task("title3","context5",false));



        MainActivity mainActivity= (MainActivity) getActivity();
        RecyclerView todayRV=view.findViewById(R.id.recyclerviewToday);
        TaskAdapter taskAdapter = new TaskAdapter(taskList,mainActivity);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mainActivity,LinearLayoutManager.VERTICAL,false);
        todayRV.setLayoutManager(linearLayoutManager);
        todayRV.setAdapter(taskAdapter);


        return view;
    }
}
