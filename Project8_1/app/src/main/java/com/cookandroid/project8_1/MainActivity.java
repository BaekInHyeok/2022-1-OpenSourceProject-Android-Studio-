/****************************
 프로그램명 : MainActivity.java
 작성자 : 2020039096 백인혁
 작성일 : 2022.04.27
 프로그램명 : 8장 실습 8-1
 ***************************/

package com.cookandroid.project8_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatePicker dp;
    EditText edtDiary;
    Button btnWrite;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.google_android);
        setTitle("간단 일기장");

        dp=(DatePicker) findViewById(R.id.datePicker1);
        edtDiary=(EditText) findViewById(R.id.edtDiary);
        btnWrite=(Button) findViewById(R.id.btnWrite);

        Calendar cal=Calendar.getInstance();
        int cYear=cal.get(Calendar.YEAR);
        int cMonth=cal.get(Calendar.MONTH);
        int cDay=cal.get(Calendar.DAY_OF_MONTH);

        dp.init(cYear, cMonth, cDay, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                fileName=Integer.toString(year)+"_"+Integer.toString(monthOfYear)+"_"+Integer.toString(dayOfMonth)+".txt";
                String str=readDiary(fileName);
                edtDiary.setText(str);
                btnWrite.setEnabled(true);
            }
        });

        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    FileOutputStream outFs=openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str=edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),fileName+" 이 저장됨",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                }
            }
        });
    }

    String readDiary(String fileName){
        String diaryStr=null;
        FileInputStream inFs;
        try{
            inFs=openFileInput(fileName);
            byte[] txt=new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr=(new String(txt)).trim();
            btnWrite.setText("수정하기");
        }catch (IOException e){
            edtDiary.setHint("일기 없음");
            btnWrite.setText("새로 저장");
        }
        return diaryStr;
    }
}