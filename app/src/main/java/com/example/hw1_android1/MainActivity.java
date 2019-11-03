package com.example.hw1_android1;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation open_menu;
    Animation close_menu;
    LinearLayout menu;
    FragmentTransaction transaction;
    Button lastday;
    Button today;
    Button nextday;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        open_menu = AnimationUtils.loadAnimation(this, R.anim.open_menu);
        close_menu = AnimationUtils.loadAnimation(this, R.anim.close_menu);
        menu=findViewById(R.id.menu);
        menu.setVisibility(View.INVISIBLE);
        ImageView buttonmenu=findViewById(R.id.butmenu);
        buttonmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i==0){
                    i++;
                    menu.setVisibility(View.VISIBLE);
                    menu.startAnimation(open_menu);
                }else{
                    i--;
                    menu.startAnimation(close_menu);
                    menu.setVisibility(View.GONE);
                }

            }
        });
        final Fragment todayfragment=new TodayFragment();
        final Fragment lastdayfragment=new LastdayFragment();
        final Fragment nextdayfragment=new NextdayFragment();
        transaction=getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment,todayfragment);
        transaction.commit();
        lastday = findViewById(R.id.lastday);
        today = findViewById(R.id.today);
        nextday = findViewById(R.id.nextday);
        lastday.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                today.setBackground(getDrawable(R.drawable.dokmerooz));
                lastday.setBackground(getDrawable(R.drawable.dokmeroozselected));
                nextday.setBackground(getDrawable(R.drawable.dokmerooz));
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment,lastdayfragment);
                transaction.commit();
            }
        });
        today.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                today.setBackground(getDrawable(R.drawable.dokmeroozselected));
                lastday.setBackground(getDrawable(R.drawable.dokmerooz));
                nextday.setBackground(getDrawable(R.drawable.dokmerooz));
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment,todayfragment);
                transaction.commit();
            }
        });
        nextday.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                today.setBackground(getDrawable(R.drawable.dokmerooz));
                lastday.setBackground(getDrawable(R.drawable.dokmerooz));
                nextday.setBackground(getDrawable(R.drawable.dokmeroozselected));
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment,nextdayfragment);
                transaction.commit();
            }
        });






    }
}


