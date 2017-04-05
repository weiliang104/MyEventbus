package com.example.wei.myeventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.greenrobot.eventbus.EventBus;

public class MainActivityb extends AppCompatActivity {
private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        bt1= (Button) findViewById(R.id.bt1);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new first("我叫挖掘机"));

            }
        });
    }
}
