package com.rusili.notificationlist;

import com.rusili.notificationlist.model.MyNotification;
import com.rusili.notificationlist.util.MyNotificationsProvider;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class MyNotificationsProviderTest {

    @Test
    public void givenValidMyNotificationsProvider_whenGetListIsCalled_thenReturnValidList(){
        // Given
        MyNotificationsProvider provider = new MyNotificationsProvider();

        // When
        List<MyNotification> result = provider.getList();

        // Then
        assertNotNull(result);
        assertNotEquals(result.size(), 0);
        assertNotEquals(result.get(0).getDrawable(), 0);
        assertNotNull(result.get(0).getMessage());
    }
}
