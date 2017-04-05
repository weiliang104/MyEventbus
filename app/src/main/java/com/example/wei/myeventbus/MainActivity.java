package com.example.wei.myeventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    private Button bt1;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        EventBus.getDefault().register(this);
        bt1 = (Button) findViewById(R.id.bt1);
        mTextView= (TextView) findViewById(R.id.tv);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivityb.class));
            }
        });
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    //    public void onthread(first event){
//        String msg=event.getMsg();
//        bt1.setText(msg);
//    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoonEvent(first event){
        bt1.setText(event.getMsg());
    }
}
