package com.example.dingsheng.testserviceautostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TestBroadcastReceiver extends BroadcastReceiver {
    private static String TAG = "TestService";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "the world!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Intent service = new Intent(context, TestSetvice.class);
        context.startForegroundService(service);
    }
}
