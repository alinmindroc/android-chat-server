package controllers;

import JSON_objects.JSONMessage;
import JSON_objects.JSONNotification;
import main.controllers.MessageController;
import main.controllers.NotificationController;
import model.Message;
import model.Notification;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class NotificationControllerTest {
    @Test
    public void testAddNotification(){
        NotificationController ctrl = new NotificationController();

        String content = "test";
        String accepted = "false";
        String recipientId = "testRecipientId";
        int id = -1;

        ctrl.addNotification(new JSONNotification(content, recipientId, accepted, id));
        List<JSONNotification> addedNotifications = ctrl.getNotifications(recipientId);

        Notification notification = (Notification) ((Object) addedNotifications.get(0));
        assertEquals(notification.getContent(), content);
        assertEquals(notification.getAccepted(), accepted);
        assertEquals(notification.getRecipientId(), recipientId);
    }
}
