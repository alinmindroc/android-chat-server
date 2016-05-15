package controllers;

import JSON_objects.JSONGroup;
import JSON_objects.JSONGroupMessage;
import JSON_objects.JSONMessage;
import main.controllers.GroupController;
import main.controllers.GroupMessageController;
import model.GroupMessage;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class GroupMessageControllerTest {

    @Test
    public void testAddGroupMessage() {
        GroupMessageController ctrl = new GroupMessageController();

        Date testDate = new Date();
        String text = "test";
        String senderId = "testSenderId";
        String senderName = "testSenderName";
        String groupId = "testGroupId";

        ctrl.addGroupMessage(new JSONGroupMessage(text, senderId, senderName, groupId, testDate));
        List<JSONGroupMessage> addedMessages = ctrl.getGroupMessages(groupId);

        GroupMessage message = (GroupMessage) ((Object) addedMessages.get(0));
        assertEquals(message.getText(), text);
        assertEquals(message.getSenderId(), senderId);
        assertEquals(message.getSenderName(), senderName);
        assertEquals(message.getGroupId(), groupId);
    }
}
