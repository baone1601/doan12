package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private EditText TotalCash;
    private TextView txt100,txt50, txt20,txt10,txt5,txt2,txt1;
    private TextView rs100,rs50, rs20,rs10,rs5,rs2,rs1;
    private TextView txtTotalCash,et100,et50,et20,et10,et5,et2,et1;
    private Button btnReset, btnConvert, btnSwitch;
    private ArrayList<Integer> fluctuateCash;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        setUpUI();
        fluctuateCash = new ArrayList<>();
        TotalCash.addTextChangedListener(new SecondActivity.CashTextWatcher());
        et100.addTextChangedListener(new SecondActivity.CashTextWatcher());
        et50.addTextChangedListener(new SecondActivity.CashTextWatcher());
        et20.addTextChangedListener(new SecondActivity.CashTextWatcher());
        et10.addTextChangedListener(new SecondActivity.CashTextWatcher());
        et5.addTextChangedListener(new SecondActivity.CashTextWatcher());
        et2.addTextChangedListener(new SecondActivity.CashTextWatcher());
        et1.addTextChangedListener(new SecondActivity.CashTextWatcher());

        txt100.addTextChangedListener(new SecondActivity.FinalCashTextWatcher());
        txt50.addTextChangedListener(new SecondActivity.FinalCashTextWatcher());
        txt20.addTextChangedListener(new SecondActivity.FinalCashTextWatcher());
        txt10.addTextChangedListener(new SecondActivity.FinalCashTextWatcher());
        txt5.addTextChangedListener(new SecondActivity.FinalCashTextWatcher());
        txt2.addTextChangedListener(new SecondActivity.FinalCashTextWatcher());
        txt1.addTextChangedListener(new SecondActivity.FinalCashTextWatcher());


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalCash.setText("");

                et100.setText("0");
                et50.setText("0");
                et20.setText("0");
                et10.setText("0");
                et5.setText("0");
                et2.setText("0");
                et1.setText("0");

                rs100.setText("0");
                rs50.setText("0");
                rs20.setText("0");
                rs10.setText("0");
                rs5.setText("0");
                rs2.setText("0");
                rs1.setText("0");
            }
        });

        TotalCash.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Không cần thực hiện thay đổi trước khi người dùng nhập
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Không cần thực hiện thay đổi khi người dùng nhập
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0 && s.charAt(0) == '0') {
                    // Nếu số nhập vào có chữ số 0 đứng đầu, xóa nó
                    s.delete(0, 1);
                }
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] arr = {100,50, 20, 10, 5, 2, 1};
                int[] no = {0, 0, 0, 0, 0, 0, 0};
                int num = 0;

                if (!TotalCash.getText().toString().equals("")) {
                    num = Integer.parseInt(TotalCash.getText().toString());
                    for (int i = 0; i < 7; i++) {
                        no[i] = num / arr[i];
                        num %= arr[i];

                        switch (i) {
                            case 0: // 50k
                                et100.setText(String.valueOf(no[i]));
                                break;
                            case 1: // 20k
                                et50.setText(String.valueOf(no[i]));

                                break;
                            case 2: // 10k
                                et20.setText(String.valueOf(no[i]));
                                break;
                            case 3: // 5k
                                et10.setText(String.valueOf(no[i]));
                                break;
                            case 4: // 2k
                                et5.setText(String.valueOf(no[i]));
                                break;
                            case 5: // 1k
                                et2.setText(String.valueOf(no[i]));
                                break;
                            case 6: // 1k
                                et1.setText(String.valueOf(no[i]));
                                break;
                        }
                    }
                }

            }
        });
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }




    private void setUpUI(){
        btnReset = findViewById(R.id.btnReset);
        btnConvert = findViewById(R.id.btnConvert);
        btnSwitch = findViewById(R.id.btnSwitchToVND);


        txtTotalCash = findViewById(R.id.txtTotalCash);
        TotalCash = findViewById(R.id.TotalCash);
        et100 = findViewById(R.id.et100);
        et50 = findViewById(R.id.et50);
        et20 = findViewById(R.id.et20);
        et10 = findViewById(R.id.et10);
        et5 = findViewById(R.id.et5);
        et2 = findViewById(R.id.et2);
        et1 = findViewById(R.id.et1);

        txt100 = findViewById(R.id.txt100);
        txt50 = findViewById(R.id.txt50);
        txt20= findViewById(R.id.txt20);
        txt10 = findViewById(R.id.txt10);
        txt5 = findViewById(R.id.txt5);
        txt2 = findViewById(R.id.txt2);
        txt1 = findViewById(R.id.txt1);

        rs100 = findViewById(R.id.rs100);
        rs50 = findViewById(R.id.rs50);
        rs20 = findViewById(R.id.rs20);
        rs10 = findViewById(R.id.rs10);
        rs5 = findViewById(R.id.rs5);
        rs2 = findViewById(R.id.rs2);
        rs1 = findViewById(R.id.rs1);
    }
    private class CashTextWatcher implements TextWatcher{

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            CashCalculate();

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
    private void CashCalculate() {
        int row_value = 0;
        DecimalFormat df = new DecimalFormat("0");
        int num1 = 0;
        if (!et100.getText().toString().equals("")){
            num1 = Integer.parseInt(et100.getText().toString());
            row_value = num1 * 100;
            rs100.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num2 = 0;
        if (!et50.getText().toString().equals("")){
            num2 = Integer.parseInt(et50.getText().toString());
            row_value = num2 * 50;
            rs50.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num3 = 0;
        if (!et20.getText().toString().equals("")){
            num3 = Integer.parseInt(et20.getText().toString());
            row_value = num3 * 20;
            rs20.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num4 = 0;
        if (!et10.getText().toString().equals("")){
            num4 = Integer.parseInt(et10.getText().toString());
            row_value = num4 * 10;
            rs10.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num5 = 0;
        if (!et5.getText().toString().equals("")){
            num5 = Integer.parseInt(et5.getText().toString());
            row_value = num5 * 5;
            rs5.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num6 = 0;
        if (!et2.getText().toString().equals("")){
            num6 = Integer.parseInt(et2.getText().toString());
            row_value = num6 * 2;
            rs2.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num7 = 0;
        if (!et1.getText().toString().equals("")){
            num7 = Integer.parseInt(et1.getText().toString());
            row_value = num7 * 1;
            rs1.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }

        if (et100.getText().toString().equals("")){
            txt100.setText(df.format(0));
        }
        if (et50.getText().toString().equals("")){
            txt50.setText(df.format(0));
        }
        if (et20.getText().toString().equals("")){
            txt20.setText(df.format(0));
        }
        if (et10.getText().toString().equals("")){
            txt10.setText(df.format(0));
        }
        if (et5.getText().toString().equals("")){
            txt5.setText(df.format(0));
        }
        if (et2.getText().toString().equals("")){
            txt2.setText(df.format(0));
        }
        if (et1.getText().toString().equals("")){
            txt1.setText(df.format(0));
        }
    }
    private class FinalCashTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }

}

