package com.example.secretdiary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NumberPicker numberPicker1;
    private NumberPicker numberPicker2;
    private NumberPicker numberPicker3;
    private Button openButton;
    private Button changePasswordButton;

    private Boolean changePasswordMode = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData(){
        numberPicker1 = findViewById(R.id.numberPicker1);
        numberPicker2 = findViewById(R.id.numberPicker2);
        numberPicker3 = findViewById(R.id.numberPicker3);
        numberPicker1.setMaxValue(0);
        numberPicker1.setMaxValue(9);
        numberPicker2.setMaxValue(0);
        numberPicker2.setMaxValue(9);
        numberPicker3.setMaxValue(0);
        numberPicker3.setMaxValue(9);

        openButton = findViewById(R.id.openButton);
        changePasswordButton = findViewById(R.id.changePasswordButton);
    }

    private void addEventListener(){
        openButton.setOnClickListener(view -> {

            if(changePasswordMode){
                Toast.makeText(this, "비밀번호 변경중 입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            //name : 파일이름
            //mode : 파일을 다른 앱과 공유하게 만들 수 있다.
            SharedPreferences passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);
            String passwordForUser = "" + numberPicker1.getValue() + numberPicker2.getValue() + numberPicker3.getValue();

            //값을 세팅하지 않았을 경우 초기값 세팅
            if(passwordPreferences.getString("password", "000").equals(passwordForUser)){
                //패스워드 성공
                //todo 다이어리 페이지 작성 후에 화면 전환 시키기
                //인텐트 쓰면 될것
                Intent intent = new Intent(this, DiaryActivity.class);
                startActivity(intent);
            }else{
                //실패
                showErrorAlertDialog();
            }

        });

        changePasswordButton.setOnClickListener(view -> {
            SharedPreferences passwordPreferences = getSharedPreferences("password", Context.MODE_PRIVATE);
            //pcr은 뭐지..?process ..
            String passwordForUser = "" + numberPicker1.getValue() + numberPicker2.getValue() + numberPicker3.getValue();
            if(changePasswordMode){
                //번호를 저장하는 기능
                SharedPreferences.Editor editor = passwordPreferences.edit();
                editor.putString("password", passwordForUser);
                editor.apply(); // apply 저장하는 녀석 , 비동기 방식
//                editor.commit(); // commit,  UI를 보여주는걸 멈추고 기다리는 방식
                changePasswordMode = false;
                changePasswordButton.setBackgroundColor(Color.BLACK);
                Toast.makeText(this, " 비밀번호가 변경 되었습니다.",Toast.LENGTH_SHORT).show();
            }else{
                //비밀번호가 맞는지 체크
                if(passwordPreferences.getString("password", "000").equals(passwordForUser)){
                    changePasswordMode = true;
                    Toast.makeText(this, "변경할 패스워드를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                    changePasswordButton.setBackgroundColor(Color.RED);
                }else{
                    showErrorAlertDialog();
                }
            }
        });
    }


    //디자인 패턴 - 빌더패턴
    //생성자 (int a, int b, int c) = new 생정자(1,2,3)
    private void showErrorAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("실패")
                .setMessage("비밀번호가 잘못되었습니다")
                .setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //동작 정의 x
                    }
                });
        builder.show();
        //화면에 띄우기
    }
}