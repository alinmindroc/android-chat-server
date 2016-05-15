package controllers;

import JSON_objects.JSONGroup;
import main.controllers.GroupController;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class GroupControllerTest {

    @Test
    public void testAddGroup(){
        GroupController ctrl = new GroupController();
        ctrl.addGroup(new JSONGroup("testname", "testMembersIds"));
        List<JSONGroup> addedGroups = ctrl.getGroups("testMembersIds");

        assertEquals(addedGroups.get(0).getName(), "testname");
        assertEquals(addedGroups.get(0).getMembersId(), "testMembersIds");
    }
}
