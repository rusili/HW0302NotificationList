package com.rusili.notificationlist.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rusili.notificationlist.R;
import com.rusili.notificationlist.model.MyNotification;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationViewHolder> {
    private final List<MyNotification> notificationList;

    public NotificationAdapter(@NonNull final List<MyNotification> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,
                                                     int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_notification, viewGroup, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder notificationViewHolder,
                                 int position) {
        notificationViewHolder.bind(position, notificationList.get(position));
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public void reset(){
        this.notifyDataSetChanged();
    }
}
