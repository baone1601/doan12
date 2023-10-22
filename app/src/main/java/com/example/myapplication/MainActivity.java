package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText TotalCash;
    private TextView txt500000,txt200000, txt100000,txt50000,txt20000, txt10000,txt5000,txt2000,txt1000;
    private TextView rs500000,rs200000, rs100000,rs50000,rs20000, rs10000,rs5000,rs2000,rs1000;
    private TextView et500,et200,et100,txtTotalCash,et50,et20,et10,et5,et2,et1;
    private Button btnReset, btnConvert, btnSwitch;
    private ArrayList<Integer> fluctuateCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();
        fluctuateCash = new ArrayList<>();
        TotalCash.addTextChangedListener(new CashTextWatcher());
        et500.addTextChangedListener(new CashTextWatcher());
        et200.addTextChangedListener(new CashTextWatcher());
        et100.addTextChangedListener(new CashTextWatcher());
        et50.addTextChangedListener(new CashTextWatcher());
        et20.addTextChangedListener(new CashTextWatcher());
        et10.addTextChangedListener(new CashTextWatcher());
        et5.addTextChangedListener(new CashTextWatcher());
        et2.addTextChangedListener(new CashTextWatcher());
        et1.addTextChangedListener(new CashTextWatcher());

        txt500000.addTextChangedListener(new FinalCashTextWatcher());
        txt200000.addTextChangedListener(new FinalCashTextWatcher());
        txt100000.addTextChangedListener(new FinalCashTextWatcher());
        txt50000.addTextChangedListener(new FinalCashTextWatcher());
        txt20000.addTextChangedListener(new FinalCashTextWatcher());
        txt10000.addTextChangedListener(new FinalCashTextWatcher());
        txt5000.addTextChangedListener(new FinalCashTextWatcher());
        txt2000.addTextChangedListener(new FinalCashTextWatcher());
        txt1000.addTextChangedListener(new FinalCashTextWatcher());

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TotalCash.setText("");

                et500.setText("0");
                et200.setText("0");
                et100.setText("0");
                et50.setText("0");
                et20.setText("0");
                et10.setText("0");
                et5.setText("0");
                et2.setText("0");
                et1.setText("0");

                rs500000.setText("0");
                rs200000.setText("0");
                rs100000.setText("0");
                rs50000.setText("0");
                rs20000.setText("0");
                rs10000.setText("0");
                rs5000.setText("0");
                rs2000.setText("0");
                rs1000.setText("0");
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

        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int[] arr = {500000, 200000, 100000,50000, 20000, 10000, 5000, 2000, 1000};
                int[] no = {0, 0, 0, 0, 0, 0, 0, 0 ,0};
                int num = 0;

                if (!TotalCash.getText().toString().equals("")) {
                    num = Integer.parseInt(TotalCash.getText().toString());
                    for (int i = 0; i < 9; i++) {
                        no[i] = num / arr[i];
                        num %= arr[i];

                        switch (i) {
                            case 0: // 500k
                                et500.setText(String.valueOf(no[i]));
                                break;
                            case 1: // 200k
                                et200.setText(String.valueOf(no[i]));
                                break;
                            case 2: // 100k
                                et100.setText(String.valueOf(no[i]));
                                break;
                            case 3: // 50k
                                et50.setText(String.valueOf(no[i]));
                                break;
                            case 4: // 20k
                                et20.setText(String.valueOf(no[i]));
                                break;
                            case 5: // 10k
                                et10.setText(String.valueOf(no[i]));
                                break;
                            case 6: // 5k
                                et5.setText(String.valueOf(no[i]));
                                break;
                            case 7: // 2k
                                et2.setText(String.valueOf(no[i]));
                                break;
                            case 8: // 1k
                                et1.setText(String.valueOf(no[i]));
                                break;
                        }
                    }
                }
            }
        });
    }



    private void setUpUI(){
        btnReset = findViewById(R.id.btnReset);
        btnConvert = findViewById(R.id.btnConvert);
        btnSwitch = findViewById(R.id.btnSwitchToUSD);

        txtTotalCash = findViewById(R.id.txtTotalCash);
        TotalCash = findViewById(R.id.TotalCash);
        et500 = findViewById(R.id.et500);
        et200 = findViewById(R.id.et200);
        et100 = findViewById(R.id.et100);
        et50 = findViewById(R.id.et50);
        et20 = findViewById(R.id.et20);
        et10 = findViewById(R.id.et10);
        et5 = findViewById(R.id.et5);
        et2 = findViewById(R.id.et2);
        et1 = findViewById(R.id.et1);

        txt500000 = findViewById(R.id.txt500000);
        txt200000 = findViewById(R.id.txt200000);
        txt100000 = findViewById(R.id.txt100000);
        txt50000 = findViewById(R.id.txt50000);
        txt20000 = findViewById(R.id.txt20000);
        txt10000 = findViewById(R.id.txt10000);
        txt5000 = findViewById(R.id.txt5000);
        txt2000 = findViewById(R.id.txt2000);
        txt1000 = findViewById(R.id.txt1000);

        rs500000 = findViewById(R.id.rs500000);
        rs200000 = findViewById(R.id.rs200000);
        rs100000 = findViewById(R.id.rs100000);
        rs50000 = findViewById(R.id.rs50000);
        rs20000 = findViewById(R.id.rs20000);
        rs10000 = findViewById(R.id.rs10000);
        rs5000 = findViewById(R.id.rs5000);
        rs2000 = findViewById(R.id.rs2000);
        rs1000 = findViewById(R.id.rs1000);
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
            if (!et500.getText().toString().equals("")){
                num1 = Integer.parseInt(et500.getText().toString());
                row_value = num1 * 500000;
                rs500000.setText(df.format(row_value));
                fluctuateCash.add(row_value);
            }
        int num2 = 0;
        if (!et200.getText().toString().equals("")){
            num2 = Integer.parseInt(et200.getText().toString());
            row_value = num2 * 200000;
            rs200000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num3 = 0;
        if (!et100.getText().toString().equals("")){
            num3 = Integer.parseInt(et100.getText().toString());
            row_value = num3 * 100000;
            rs100000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num4 = 0;
        if (!et50.getText().toString().equals("")){
            num4 = Integer.parseInt(et50.getText().toString());
            row_value = num4 * 50000;
            rs50000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num5 = 0;
        if (!et20.getText().toString().equals("")){
            num5 = Integer.parseInt(et20.getText().toString());
            row_value = num5 * 20000;
            rs20000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num6 = 0;
        if (!et10.getText().toString().equals("")){
            num6 = Integer.parseInt(et10.getText().toString());
            row_value = num6 * 10000;
            rs10000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num7 = 0;
        if (!et5.getText().toString().equals("")){
            num7 = Integer.parseInt(et5.getText().toString());
            row_value = num7 * 5000;
            rs5000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num8 = 0;
        if (!et2.getText().toString().equals("")){
            num8 = Integer.parseInt(et2.getText().toString());
            row_value = num8* 2000;
            rs2000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }
        int num9 = 0;
        if (!et1.getText().toString().equals("")){
            num9 = Integer.parseInt(et1.getText().toString());
            row_value = num9 * 1000;
            rs1000.setText(df.format(row_value));
            fluctuateCash.add(row_value);
        }

        if (et500.getText().toString().equals("")){
            txt500000.setText(df.format(0));
        }
        if (et200.getText().toString().equals("")){
            txt200000.setText(df.format(0));
        }
        if (et100.getText().toString().equals("")){
            txt100000.setText(df.format(0));
        }
        if (et50.getText().toString().equals("")){
            txt50000.setText(df.format(0));
        }
        if (et20.getText().toString().equals("")){
            txt20000.setText(df.format(0));
        }
        if (et10.getText().toString().equals("")){
            txt10000.setText(df.format(0));
        }
        if (et5.getText().toString().equals("")){
            txt5000.setText(df.format(0));
        }
        if (et2.getText().toString().equals("")){
            txt2000.setText(df.format(0));
        }
        if (et1.getText().toString().equals("")){
            txt1000.setText(df.format(0));
        }
    }
    private class FinalCashTextWatcher implements TextWatcher{

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
