package com.rusili.notificationlist;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.rusili.notificationlist.model.MyNotification;
import com.rusili.notificationlist.recyclerview.NotificationAdapter;
import com.rusili.notificationlist.util.MyNotificationListProvider;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String SHARED_PREFERENCES_KEY = "com.rusili.notificationlist";

    private RecyclerView notificationRv;
    private NotificationAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView(new MyNotificationListProvider().getList());
        setupOnClickListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.reset();
    }

    private void setupRecyclerView(@NonNull final List<MyNotification> list) {
        notificationRv = findViewById(R.id.notificationRecyclerView);
        notificationRv.setLayoutManager(getLayoutManager());
        notificationRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        notificationRv.setHasFixedSize(true);

        adapter = new NotificationAdapter(list);
        notificationRv.setAdapter(adapter);
    }

    private void setupOnClickListener() {
        findViewById(R.id.activityMainResetPreferences).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE)
                        .edit()
                        .clear()
                        .apply();
                notificationRv.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), R.string.shared_preferences_cleared, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    private LinearLayoutManager getLayoutManager() {
        final int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE){
            return new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        } else {
            return new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        }
    }
}
