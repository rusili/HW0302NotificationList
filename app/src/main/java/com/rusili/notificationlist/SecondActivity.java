package com.rusili.notificationlist;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public static final String NOTIFICATION_INDEX_KEY = "notification index";
    public static final String NOTIFICATION_MESSAGE_KEY = "notification message";
    public static final String NOTIFICATION_DRAWABLE_KEY = "notification drawable";

    private static final String NOTIFICATION_CHANNEL_ID = "ID";
    private static final String NOTIFICATION_CHANNEL_NAME = "NAME";

    private NotificationManager notificationManager;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        createNotificationChannel();

        sharedPreferences = getSharedPreferences(MainActivity.SHARED_PREFERENCES_KEY, MODE_PRIVATE);

        final Intent intent = getIntent();
        final int index = intent.getIntExtra(NOTIFICATION_INDEX_KEY, -1);
        final String message = intent.getStringExtra(NOTIFICATION_MESSAGE_KEY);
        final int drawable = intent.getIntExtra(NOTIFICATION_DRAWABLE_KEY, 0);

        ((TextView) findViewById(R.id.activityNotificationMessage)).setText(message);
        ((ImageView) findViewById(R.id.activityNotificationImage)).setImageResource(drawable);

        findViewById(R.id.activitySendNotification).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (notificationAlreadySent(message)) {
                    Toast.makeText(getApplicationContext(), R.string.notification_sent_toast, Toast.LENGTH_SHORT).show();
                } else {
                    createNotification(index, message, drawable);
                    saveNotificationSent(message);
                }

                finish();
            }
        });
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            final NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }
    }

    private void createNotification(final int index,
                                    @NonNull final String message,
                                    @DrawableRes final int icon) {
        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                .setSmallIcon(icon)
                .setContentText(message);
        notificationManager.notify(index, notificationBuilder.build());
    }

    private void saveNotificationSent(final @NonNull String message) {
        sharedPreferences.edit()
                .putBoolean(message, true)
                .apply();
    }

    private boolean notificationAlreadySent(final @NonNull String message) {
        return sharedPreferences.getBoolean(message, false);
    }
}
