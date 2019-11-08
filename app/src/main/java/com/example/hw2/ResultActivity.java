package com.example.hw2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent_result = getIntent();                                  //取得 intent
        String str = intent_result.getStringExtra("data");      // 抓取 intent  所傳過來名為 data 的內容
        float bmi = intent_result.getFloatExtra("BMI",0);     //getFloatExtra(名稱,預設值)  預設值填 0 就可以了
        TextView txv_result_show = (TextView)findViewById(R.id.txv_result_show);
        str = str + "  " + String.valueOf(bmi);                        // 將浮點數轉為字串 String.valueOf
        if(bmi>25) {
            str = str + " 過重";
        }else if (bmi<20) {
            str = str + " 過輕";
        } else {
            str = str + " 恭喜你!!";
        }
        txv_result_show.setText(str);                                   // 將最後結果顯示在 TextView


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_main = new Intent(ResultActivity.this,MainActivity.class);

            }

        });
    }
}
