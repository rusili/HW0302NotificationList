package com.rusili.notificationlist.util;

import android.support.annotation.NonNull;

import com.rusili.notificationlist.R;
import com.rusili.notificationlist.model.MyNotification;

import java.util.Arrays;
import java.util.List;

public class MyNotificationsProvider {
    private final List<MyNotification> myNotificationsList = Arrays.asList(
            new MyNotification("Hello there", R.drawable.ic_android_black_24dp),
            new MyNotification("My name is Rusi", R.drawable.ic_account_box),
            new MyNotification("You got a message", R.drawable.ic_announcement_black_24dp),
            new MyNotification("This is another notification", R.drawable.ic_accessible),
            new MyNotification("Mo' money, mo' problems", R.drawable.ic_attach_money_black_24dp),
            new MyNotification("Take a picture!", R.drawable.ic_aspect_ratio_black_24dp),
            new MyNotification("Make some music", R.drawable.ic_audiotrack_black_24dp),
            new MyNotification("Anyone remember Clippy?", R.drawable.ic_attach_file_black_24dp),
            new MyNotification("You ordered a 4 pepperoni pizza", R.drawable.ic_av_timer_black_24dp),
            new MyNotification("It's been a long day without you my friend", R.drawable.ic_call_split_black_24dp)
    );

    @NonNull
    public List<MyNotification> getList() {
        return myNotificationsList;
    }
}
