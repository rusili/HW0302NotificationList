package com.rusili.notificationlist.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rusili.notificationlist.MainActivity;
import com.rusili.notificationlist.R;
import com.rusili.notificationlist.SecondActivity;
import com.rusili.notificationlist.model.MyNotification;

class NotificationViewHolder extends RecyclerView.ViewHolder {

    NotificationViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    void bind(final int position,
              @Nullable final MyNotification notification) {
        if (notification == null) {
            return;
        }

        ((TextView) itemView.findViewById(R.id.notificationMessage))
                .setText(notification.getMessage());
        ((ImageView) itemView.findViewById(R.id.notificationImage))
                .setImageDrawable(itemView.getResources().getDrawable(notification.getDrawable()));

        setupBackground(notification);
        setupOnClickListener(position, notification);
    }

    private void setupBackground(@NonNull final MyNotification notification) {
        final boolean notificationSent = itemView.getContext()
                .getSharedPreferences(MainActivity.SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE)
                .getBoolean(notification.getMessage(), false);

        if (notificationSent) {
            @ColorInt int color = itemView.getResources().getColor(android.R.color.darker_gray);
            itemView.findViewById(R.id.viewholderLayout).setBackgroundColor(color);
        }
    }

    private void setupOnClickListener(final int position,
                                      @NonNull final MyNotification notification) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent toSecondActivity = new Intent(v.getContext(), SecondActivity.class);
                toSecondActivity.putExtra(SecondActivity.NOTIFICATION_INDEX_KEY, position);
                toSecondActivity.putExtra(SecondActivity.NOTIFICATION_MESSAGE_KEY, notification.getMessage());
                toSecondActivity.putExtra(SecondActivity.NOTIFICATION_DRAWABLE_KEY, notification.getDrawable());
                v.getContext().startActivity(toSecondActivity);
            }
        });
    }
}
