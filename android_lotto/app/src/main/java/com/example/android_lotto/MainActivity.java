package com.example.android_lotto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button addBtn;
    private Button initBtn;
    private Button runBtn;
    private NumberPicker numberPicker;
    private boolean didRun = false;

    private ArrayList<TextView> numberTextViewList = new ArrayList<>();
    private Set<Integer> pickerNumberSet = new HashSet<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        addEventListener();
    }

    private void initData(){
        addBtn = findViewById(R.id.addButton);
        initBtn = findViewById(R.id.initButton);
        runBtn = findViewById(R.id.runButton);

        //넘버픽커 값 세팅
        numberPicker = findViewById(R.id.numberPicker);
        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(45);
        //텍스트 뷰 가져오기
        numberTextViewList.add(findViewById(R.id.textView1));
        numberTextViewList.add(findViewById(R.id.textView2));
        numberTextViewList.add(findViewById(R.id.textView3));
        numberTextViewList.add(findViewById(R.id.textView4));
        numberTextViewList.add(findViewById(R.id.textView5));
        numberTextViewList.add(findViewById(R.id.textView6));
    }

    private Drawable setTextViewBackground(int number){

        Drawable drawable;
        //Drawble Resource를 가져오는 방법(코드)

//        Drawable drawableId = ContextCompat.getDrawable(this, R.drawable.round_background_1);
        //관계연산자 읽기 : 왼쪽 항이 오른쪽 항보다 작다. 로 이해하면 좋다.
        if(number <= 10){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_1);
        }else if(number < 21){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_2);
        }else if(number < 31){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_3);
        }else if(number < 41){
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_4);
        }else{
            drawable = ContextCompat.getDrawable(this, R.drawable.round_background_5);
        }
        return drawable;
    }

    private void addEventListener(){
        runBtn.setOnClickListener(view -> {

            //todo 랜덤번호 생성하기
            List<Integer> list = getRandomNumber();
            Log.d("TAG", getRandomNumber().toString());

            list.addAll(pickerNumberSet);
            Collections.sort(list);
            for(int i = 0; i < list.size(); i++){
                int randomNumber = list.get(i);
                numberTextViewList.get(i).setText(String.valueOf(randomNumber));
                numberTextViewList.get(i).setVisibility(View.VISIBLE);
                numberTextViewList.get(i).setBackground(setTextViewBackground(randomNumber));
                //todo 텍스트 뷰 백그라운드 그리기
            }
            didRun = true;
        });

        addBtn.setOnClickListener(view -> {
            //번호 추가하기
            int selectedNumber = numberPicker.getValue();

            //에외처리
            if(didRun) {
                Toast.makeText(this, "초기화 후에 시도해주세요", Toast.LENGTH_SHORT).show();
                return;
            }
            if(pickerNumberSet.size() >=5 ) {
                Toast.makeText(this, "번호는 5개까지만 선택 가능합니다.", Toast.LENGTH_SHORT).show();
                return;
            }
            //번호는 다섯개 까지 선택가능

            if(pickerNumberSet.contains(selectedNumber) ) {
                Toast.makeText(this, "이미 선택한 번호입니다.", Toast.LENGTH_SHORT).show();
                return;
            }

            TextView textView = numberTextViewList.get(pickerNumberSet.size());
            textView.setVisibility(View.VISIBLE);
            textView.setText(String.valueOf(selectedNumber));
            textView.setBackground(setTextViewBackground(selectedNumber));


            pickerNumberSet.add(selectedNumber);
            Log.d("TAG", pickerNumberSet.toString());
        });

        initBtn.setOnClickListener(view -> {
            //초기화 하기
            didRun = false;
            pickerNumberSet.clear();
            for (TextView tv : numberTextViewList) {
                tv.setVisibility(View.GONE);
            }
        });
    }
    private List<Integer> getRandomNumber(){
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            if(pickerNumberSet.contains(i)){
                continue;
            }
            numberList.add(i);
        }
        Collections.shuffle(numberList);
        return numberList.subList(0, 6 - pickerNumberSet.size());
        //subList(0,6) 뜻 :   (시작 인덱스, 총 인덱스 길이??)
    }
}