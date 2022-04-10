/****************
프로그램명 : MainActivity.java
작성자 : 2020039096 백인혁
작성일 : 2022.03.30
프로그램명 : 4장 연습문제 9번
*****************/

package com.example.chapter4practice8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edittext;
    String Text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //앱 아이콘 설정
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.google_android);

        //제목 설정
        setTitle("연습문제 4-8");

        edittext=(EditText) findViewById(R.id.Edittext);

        //책에 나와있는 setONKeyListener()를 이용하라는 힌트는 키가 눌릴때마다 토스트 메시지를 구현하는 것이 불가능했다
        //탐구 결과 addTextChangeListener()를 이용하면 키가 눌릴 때마다 출력이 가능했다
        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //키보드 입력으로 EditText 위젯의 내용이 바뀔 때마다 토스트 메시지를 출력한다.
                Toast.makeText(getApplicationContext(),charSequence.toString(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable editable) { }
        });
    }
}