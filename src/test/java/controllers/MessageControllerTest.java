package controllers;

import JSON_objects.JSONGroupMessage;
import JSON_objects.JSONMessage;
import main.controllers.GroupMessageController;
import main.controllers.MessageController;
import model.GroupMessage;
import model.Message;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class MessageControllerTest {
    @Test
    public void testAddMessage(){
        MessageController ctrl = new MessageController();

        Date testDate = new Date();
        String content = "test";
        String senderId = "testSenderId";
        String receiverId = "testReceiverId";
        String senderName = "testSenderName";
        String receiverName = "testReceiverName";

        ctrl.addMessage(new JSONMessage(content, senderId, receiverId, senderName, receiverName, testDate));
        List<JSONMessage> addedMessages = ctrl.getMessages(receiverId, senderId);

        Message message = (Message) ((Object) addedMessages.get(0));
        assertEquals(message.getText(), content);
        assertEquals(message.getSenderId(), senderId);
        assertEquals(message.getSenderName(), senderName);
        assertEquals(message.getReceiverId(), receiverId);
        assertEquals(message.getReceiverName(), receiverName);
    }
}
