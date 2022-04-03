/*
 * 프로그램명 : MainActivity.java
 * 작성자 : 2020039096 백인혁
 * 작성일 : 2022.03.24
 * 프로그램 설명 : Week3 HW MainActivity.java
 * */

package com.example.a2020039096baekinhyeok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*위젯에 관계되는 변수들을 선언한다.*/
    EditText text;
    Button ToastBtn;
    Button URLBtn;
    RadioGroup rGroup;
    RadioButton android11, android12;
    ImageView imgAndroidVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("좀 그럴듯한 앱");//어플리케이션 화면의 제목 표시줄 변경

        text=(EditText)findViewById(R.id.EditText);//EditText 위젯을 변수 text에 대입

        /*EditText에 입력된 문자열을 Toast 출력하는 버튼*/
        ToastBtn=(Button)findViewById(R.id.PrintTextBtn);//PrintTextBtn 위젯을 변수 ToastBtn에 대입
        ToastBtn.setOnClickListener(new View.OnClickListener() {//<글자 나타내기> 버튼을 클릭했을 때의 리스너 설정
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),text.getText(),Toast.LENGTH_SHORT).show();
                //변수 text에서 입력받은 데이터를 받아와 화면에 잠깐 출력한다.
            }
        });

        /*EditText에 입력된 URL을 인터넷 웹사이트로 여는 버튼*/
        URLBtn=(Button)findViewById(R.id.PrintURLBtn);//PrintURLBtn 위젯을 변수 URLBtn에 대입
        URLBtn.setOnClickListener(new View.OnClickListener() {//<홈페이지 열기> 버튼을 클릭했을 때의 리스너 설정
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(text.getText().toString()));
                startActivity(intent);
                //변수 text에서 String 형식으로 데이터를 받아와 해당 데이터가 가리키는 웹페이지를 연다.
            }
        });

        /*RadioButton 선택에 따라 그림 바꾸기*/
        android11=(RadioButton)findViewById(R.id.picture1);//picture1 위젯을 변수 android11에 대입
        android12=(RadioButton)findViewById(R.id.picture2);//picture2 위젯을 변수 android12에 대입

        imgAndroidVersion=(ImageView)findViewById(R.id.androidimage);//androidimage 위젯을 변수 imgAndroidVersion에 대입

        imgAndroidVersion.setImageResource(R.drawable.android11);//android11.png를 화면에 출력할 기본 이미지로 설정

        //<11.0(R)> 라디오 버튼을 선택했을 때의 리스너
        android11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//
                imgAndroidVersion.setImageResource(R.drawable.android11);//이미지뷰어에 출력할 이미지를 android11.png로 설정
            }
        });

        //<12.0(S)> 라디오 버튼을 선택했을 때의 리스너
        android12.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgAndroidVersion.setImageResource(R.drawable.android12);//이미지뷰어에 출력할 이미지를 android12.png로 설정
            }
        }));

        /*앱 아이콘 출력 : android12.png로 설정하려 했으나 png파일의 모양 때문에 앱 제목이 옆으로 밀려 google_android.png 파일을 사용하였다.*/
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.google_android);
    }
}