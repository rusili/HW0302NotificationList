package com.rusili.notificationlist.model;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

public class MyNotification {
    private String message;
    private @DrawableRes int drawable;

    public MyNotification(@NonNull final String message,
                          @DrawableRes final int drawable) {
        this.message = message;
        this.drawable = drawable;
    }

    @NonNull
    public String getMessage() {
        return message;
    }

    public int getDrawable() {
        return drawable;
    }
}
