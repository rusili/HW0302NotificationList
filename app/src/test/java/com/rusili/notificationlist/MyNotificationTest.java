package com.rusili.notificationlist;

import com.rusili.notificationlist.model.MyNotification;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class MyNotificationTest {

    @Test
    public void givenValidMyNotification_whenGetMessageIsCalled_ReturnGivenMessage(){
        // Given
        final String message = "message";
        final MyNotification testSubject = new MyNotification(message, 1);

        // When
        String result = testSubject.getMessage();

        // Then
        assertNotNull(result);
        assertEquals(result, message);
    }

    @Test
    public void givenValidMyNotification_whenGetDrawableIsCalled_ReturnGivenDrawable(){
        // Given
        final int drawable = 2120;
        final MyNotification testSubject = new MyNotification("message", drawable);

        // When
        int result = testSubject.getDrawable();

        // Then
        assertNotEquals(result, 0);
        assertEquals(result, drawable);
    }
}
