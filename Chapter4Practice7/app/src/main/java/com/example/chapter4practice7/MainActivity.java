/****************************
프로그램명 : MainActivity.java
작성자 : 2020039096 백인혁
작성일 : 2022.03.30
프로그램명 : 4장 연습문제 7번
*************************8*/
package com.example.chapter4practice7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class MainActivity extends AppCompatActivity {
    CheckBox checkbox1,checkbox2,checkbox3;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //앱 아이콘 설정
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.google_android);

        //제목 변경
        setTitle("연습문제 4-7");

        //위젯과 변수 연결
        checkbox1=(CheckBox) findViewById(R.id.ChkEnable);
        checkbox2=(CheckBox) findViewById(R.id.ChkClickable);
        checkbox3=(CheckBox) findViewById(R.id.ChkRotate);
        btn=(Button) findViewById(R.id.Button);

        //Enabled 속성 Checkbox 체크박스변경리스너
        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkbox1.isChecked()==true){
                    btn.setEnabled(true);
                }
                else{
                    btn.setEnabled(false);
                }
            }
        });

        //Clickable 속성 Checkbox 체크박스변경리스너
        checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkbox2.isChecked()==true){
                    btn.setClickable(true);
                }
                else{
                    btn.setClickable(false);
                }
            }
        });

        //45도 회전 유무 Checkbox 체크박스변경리스너
        checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(checkbox3.isChecked()==true) {
                    btn.setRotation(45);
                }else
                {
                    btn.setRotation(0);
                }
            }
        });
    }
}