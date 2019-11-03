package com.example.hw1_android1;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class LoginActivity extends AppCompatActivity {
    String pass="1234";
    String input="";
    int cnt=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void ClickNumber(View view) throws InterruptedException {
        Button button=(Button) view;
        Button circle=findViewById(R.id.circle1);
        Button circle2=findViewById(R.id.circle2);
        Button circle3=findViewById(R.id.circle3);
        Button circle4=findViewById(R.id.circle4);
        if(cnt==0){
            cnt++;
            input=input+button.getText();
            circle.setBackground(getDrawable(R.drawable.dayere2));
        }else if(cnt==1){
            cnt++;
            input=input+button.getText();
            circle2.setBackground(getDrawable(R.drawable.dayere2));
        }else if(cnt==2){
            cnt++;
            input=input+button.getText();
            circle3.setBackground(getDrawable(R.drawable.dayere2));
        }else if(cnt==3) {
            cnt=0;
            input=input+button.getText();
            if (input.equals(pass)){
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                input="";
                cnt=0;
                circle.setBackground(getDrawable(R.drawable.dayere));
                circle2.setBackground(getDrawable(R.drawable.dayere));
                circle3.setBackground(getDrawable(R.drawable.dayere));
                circle4.setBackground(getDrawable(R.drawable.dayere));

            }else{
                circle.setBackground(getDrawable(R.drawable.dayere));
                circle2.setBackground(getDrawable(R.drawable.dayere));
                circle3.setBackground(getDrawable(R.drawable.dayere));
                circle4.setBackground(getDrawable(R.drawable.dayere));
                cnt=0;
                input="";
                final Animation animShake = AnimationUtils.loadAnimation(this, R.anim.shake);
                LinearLayout dokmeha =findViewById(R.id.dokmeha);
                dokmeha.startAnimation(animShake);
            }
        }

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void Clickbackspace(View view){
        Button circle=findViewById(R.id.circle1);
        Button circle2=findViewById(R.id.circle2);
        Button circle3=findViewById(R.id.circle3);
        Button circle4=findViewById(R.id.circle4);
        if (cnt==3){
            circle3.setBackground(getDrawable(R.drawable.dayere));
            cnt--;
            input=input.substring(0,input.length()-1);
        }else if (cnt==2){
            circle2.setBackground(getDrawable(R.drawable.dayere));
            cnt--;
            input=input.substring(0,input.length()-1);
        }else if (cnt==1){
            circle.setBackground(getDrawable(R.drawable.dayere));
            cnt--;
            input=input.substring(0,input.length()-1);
        }
    }
}
