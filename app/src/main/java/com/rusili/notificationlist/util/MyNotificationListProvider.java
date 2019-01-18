package com.rusili.notificationlist.util;

import android.support.annotation.NonNull;

import com.rusili.notificationlist.R;
import com.rusili.notificationlist.model.MyNotification;

import java.util.Arrays;
import java.util.List;

public class MyNotificationListProvider {
    private final List<MyNotification> myNotificationsList = Arrays.asList(
            new MyNotification("Hello there", R.drawable.ic_android_black_24dp),
            new MyNotification("My name is Rusi", R.drawable.ic_account_box),
            new MyNotification("You got a message", R.drawable.ic_announcement_black_24dp),
            new MyNotification("This is another notification", R.drawable.ic_accessible),
            new MyNotification("3d is awesome", R.drawable.ic_3d_rotation));

    @NonNull
    public List<MyNotification> getList() {
        return myNotificationsList;
    }
}
