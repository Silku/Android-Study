package com.example.myactivity_1;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator2 extends AppCompatActivity {

    TextView zero;
    TextView one;
    TextView two;
    TextView three;
    TextView four;
    TextView five;
    TextView six;
    TextView seven;
    TextView eight;
    TextView nine;
    TextView ca;
    TextView plus;
    TextView minus;
    TextView multiply;
    TextView divide;
    TextView equals;
    TextView result;
    // new --> old (newValue + oldValue)
    String newValue = "0";
    String oldValue = "0";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator2);
        initData();
        addEventListener();
    }

    private String removeZero() {
        if(newValue.length() > 15) {
            newValue = newValue.substring(0, 15);
            //substring 문자열의 index를 지정하는 메서드
        }
        // 맨 앞쪽자리 0을 제거 하는 역할
        return Long.parseLong(newValue) + "";
    }

    private void checkDataType() {
        // 5.0;
        // .0
        // 5.0
        //oldValue =  5
        String checkType = oldValue.substring(oldValue.length() - 2);
        if(checkType.equals(".0")) {
            oldValue = oldValue.substring(0, oldValue.length() - 2);
        }
    }


    private void initData() {
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ca = findViewById(R.id.ca);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);
        equals = findViewById(R.id.equals);
        result = findViewById(R.id.result);
    }

    private void addEventListener() {
        zero.setOnClickListener(view -> {
            newValue = newValue + "0";
            result.setText(removeZero());
        });
        one.setOnClickListener(view -> {
            newValue = newValue + "1";
            result.setText(removeZero());
        });
        two.setOnClickListener(view -> {
            newValue = newValue + "2";
            result.setText(removeZero());
        });
        three.setOnClickListener(view -> {
            newValue = newValue + "3";
            result.setText(removeZero());
        });
        four.setOnClickListener(view -> {
            newValue = newValue + "4";
            result.setText(removeZero());
        });
        five.setOnClickListener(view -> {
            newValue = newValue + "5";
            result.setText(removeZero());
        });
        six.setOnClickListener(view -> {
            newValue = newValue + "6";
            result.setText(removeZero());
        });
        seven.setOnClickListener(view -> {
            newValue = newValue + "7";
            result.setText(removeZero());
        });
        eight.setOnClickListener(view -> {
            newValue = newValue + "8";
            result.setText(removeZero());
        });
        nine.setOnClickListener(view -> {
            newValue = newValue + "9";
            result.setText(removeZero());
        });

        ca.setOnClickListener(view -> {
            newValue = "0";
            oldValue = "0";
            operator = "";
            result.setText(removeZero());
        });

        plus.setOnClickListener(view -> {
            calPlus();
        });
        minus.setOnClickListener(view -> {
            calMinus();
        });
        multiply.setOnClickListener(view -> {

            calMultiply();
        });
        divide.setOnClickListener(view -> {
            calDivide();
        });

        equals.setOnClickListener(view -> {
            if(operator.equals("+")) {
                calPlus();
            } else if (operator.equals("-")) {
                calMinus();
            } else if(operator.equals("*")) {
                calMultiply();
            } else if(operator.equals("/")) {
                calDivide();
            }
        });
    }

    private void calDivide() {
        operator = "/";
        if(oldValue.equals("0")) {
            newValue = "0";
            oldValue = newValue;
        } else {
            if(newValue.equals("00")) {
                result.setText("0으로 나눌 수 없습니다.");
                oldValue = "0";
                newValue = "0";
                return;
            }

            if(!newValue.equals("0")) {
                double number1 = Double.parseDouble(oldValue);
                double number2 = Double.parseDouble(newValue);
                double sum = (number1 / number2);
                // 마지막 연산 값 저장
                oldValue =  String.valueOf(sum);
                checkDataType();
                result.setText(oldValue);
            }
        }
    }

    private void calMultiply() {
        operator = "*";
        if(oldValue.equals("0")) {
            oldValue = newValue;
            newValue = "0";
        } else {
            double number1 = Double.parseDouble(oldValue);
            double number2 = Double.parseDouble(newValue);
            double sum = (number1 * number2);
            // 마지막 연산 값 저장
            oldValue =  String.valueOf(sum);
            checkDataType();
            result.setText(oldValue);
        }
    }

    private void calMinus() {
        operator = "-";
        if (oldValue.equals("0")) {
            oldValue = newValue;
            newValue = "0";
        } else {
            double number1 = Double.parseDouble(oldValue);
            double number2 = Double.parseDouble(newValue);
            double sum = (number1 - number2);
            // 마지막 연산 값 저장
            oldValue =  String.valueOf(sum);
            newValue = "0";
            checkDataType();
            result.setText(oldValue);
        }
    }


    // 더하는 메서드
    private void calPlus() {
        operator = "+";
        double number1 = Double.parseDouble(oldValue);
        double number2 = Double.parseDouble(newValue);
        double sum = (number1 + number2);
        // 마지막 연산 값 저장
        oldValue =  String.valueOf(sum);
        newValue = "0";

        checkDataType();
        result.setText(oldValue);
    }

}