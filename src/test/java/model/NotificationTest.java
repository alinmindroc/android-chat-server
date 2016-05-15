package model;

import main.controllers.MessageController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NotificationTest {

    @Test
    public void testGroup(){
        Notification notification = new Notification();
        notification.setId(1);
        notification.setContent("test");
        notification.setRecipientId("testMembersId");

        assertEquals(notification.getId(), 1);
        assertEquals(notification.getContent(), "test");
        assertEquals(notification.getRecipientId(), "testMembersId");
    }
}
