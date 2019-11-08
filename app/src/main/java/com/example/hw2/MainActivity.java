package com.example.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button btn_cal = (Button)findViewById(R.id.btn_calculate);
        // 底下按鈕的 setOnClickListener 是用來接「當按鈕被點一下 One-Click」的事件反應，當然你要抓其他事件的處理名稱，
        // 就必須找對應的 http://developer.android.com/reference/android/view/View.html
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {   // OnClick 所要做的事件寫在下面區塊中
                EditText edv_height = (EditText)findViewById(R.id.edt_height);  // 抓取 Activity R 中的 EditText元件
                EditText edv_weight = (EditText)findViewById(R.id.edt_weight);
                PassValue(edv_height.getText().toString(), edv_weight.getText().toString());
                // 我把計算 BMI 的動作抽出去到  PassVaule Function 去處理
            }
        });  // 注意這個右括弧是對應 setOnClickListener
    }
    public void PassValue(String s_height, String s_weight){
        float height = Float.valueOf(s_height);       // 計算的時候，型別要一致才不會導致計算錯誤
        //  轉換型別的時候有時可以簡單使用 (type) 的方式轉，但這個傳過來的 String 就需要以 Type.valueOf （如 Float.valueOf）來轉換
        float weight = Float.valueOf(s_weight);      // 雖然某些計算值可以為 int 例如體重，但如果體重 weight 你給 int 型別會導致計算上的錯誤
        float bmi;
        height = height / 100 ;                                 // 將公分的身高轉為公尺單位
        bmi = weight / (height*height);
        TextView txv_r = (TextView)findViewById(R.id.txv_result);


        txv_r.setText("你的BMI指數為"  );                    // 自串串接用 + 號
        Intent intent_main = new Intent(MainActivity.this,ResultActivity.class);   // intent 建立
        intent_main.putExtra("data",txv_r.getText());   // 將內容透過 data ，將第二欄位的值傳過去
        intent_main.putExtra("BMI",bmi);                     // 同時傳多筆資料到別的 activity ，以名稱來辨別
        startActivity(intent_main);                                  //這是轉換到另一個 Activity
        // finish();                                                              // 用以結束這個 Activity
    }
}

