package com.lucky.lib.studyapp;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class Main2Activity extends AppCompatActivity {

    private static int MESSAGE_KEY = 0x2019;
    @SuppressLint("HandlerLeak")
    private static Handler sHandler =new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what ==MESSAGE_KEY) {
                if (msg.obj!=null) {
                    Log.i("xmq", String.valueOf(msg.obj));
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendMessage(getClass().getSimpleName());
    }

    private void sendMessage(String string) {
        Message message = new Message();
        message.what =MESSAGE_KEY;
        message.obj = string;
        sHandler.sendMessage(message);
    }
}
