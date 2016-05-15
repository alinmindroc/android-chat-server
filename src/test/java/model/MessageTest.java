package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageTest {

    @Test
    public void testGroup(){
        Message message = new Message();
        message.setId(1);
        message.setText("test");
        message.setSenderId("testMembersId");

        assertEquals(message.getId(), 1);
        assertEquals(message.getText(), "test");
        assertEquals(message.getSenderId(), "testMembersId");
    }
}
