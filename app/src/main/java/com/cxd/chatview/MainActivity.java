package com.cxd.chatview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cxd.chatview.moudle.ChatView;


public class MainActivity extends AppCompatActivity {

    ChatView firstView,thirdView ;
    Activity context ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this ;

        firstView = findViewById(R.id.firstView);
        thirdView = findViewById(R.id.thirdView);
        firstView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"触发点击事件",Toast.LENGTH_SHORT).show();
            }
        });

        thirdView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context,"触发长按事件",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
