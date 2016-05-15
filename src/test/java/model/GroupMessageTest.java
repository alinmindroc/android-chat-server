package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupMessageTest {

    @Test
    public void testGroup(){
        GroupMessage groupMessage = new GroupMessage();
        groupMessage.setId(1);
        groupMessage.setText("test");
        groupMessage.setGroupId("testMembersId");

        assertEquals(groupMessage.getId(), 1);
        assertEquals(groupMessage.getText(), "test");
        assertEquals(groupMessage.getGroupId(), "testMembersId");
    }
}
