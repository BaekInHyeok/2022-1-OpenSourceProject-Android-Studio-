/****************************
프로그램명 : MainActivity.java
작성자 : 2020039096 백인혁
작성일 : 2022.03.30
프로그램명 : 4장 연습문제 9번
****************************/
package com.example.chapter4practice9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button Btn;
    ImageView Image;
    int temp=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*앱 아이콘 설정*/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.google_android);

        //제목 설정
        setTitle("연습문제4-9");

        //변수들을 해당 위젯에 연결
        Btn=(Button) findViewById(R.id.btn);
        Image=(ImageView) findViewById(R.id.img);

        //'회전하기' 버튼을 누를 때마다 10도씩 회전하게 하는 클릭리스너
        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp=temp+10;
                Image.setRotation(temp);//temp에 저장된 수치만큼 그림 회전
            }
        });
    }
}