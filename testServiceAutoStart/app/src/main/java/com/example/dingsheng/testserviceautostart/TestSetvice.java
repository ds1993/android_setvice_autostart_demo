package com.example.dingsheng.testserviceautostart;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class TestSetvice extends Service {
    private static final String TAG = "TestService";

    private class TestHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "fuck!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    private TestHandler mHandler = new TestHandler();
    private Timer mTimer = new Timer();
    private TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
            mHandler.obtainMessage().sendToTarget();
        }
    };

    public TestSetvice() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        String id = "myChannel";
        CharSequence name = "TestSetvice";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel channel = new NotificationChannel(id, name, importance);
        notificationManager.createNotificationChannel(channel);
        int notifyId = 1;
        String channelId = "myChannel";
        Notification notification = new Notification.Builder(this).setContentTitle("new message").setContentText("fuck").setChannelId(channelId).build();
        startForeground(notifyId, notification);
        mTimer.schedule(mTimerTask, 0, 2000);
        Log.d(TAG, "###########################");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
