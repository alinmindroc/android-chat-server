package model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupTest {

    @Test
    public void testGroup(){
        Group group = new Group();
        group.setId(1);
        group.setName("test");
        group.setMembersId("testMembersId");

        assertEquals(group.getId(), 1);
        assertEquals(group.getName(), "test");
        assertEquals(group.getMembersId(), "testMembersId");
    }
}
