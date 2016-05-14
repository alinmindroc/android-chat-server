package main.controllers;

import JSON_objects.JSONGroupMessage;
import dao.GroupMessageDao;
import main.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupMessageController {
    private AnnotationConfigApplicationContext ctx;
    private GroupMessageDao groupMessageDao;

    public GroupMessageController(){
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        groupMessageDao = ctx.getBean(GroupMessageDao.class);
    }

    @RequestMapping(value = "/groupMessage", method = RequestMethod.GET)
    public List<JSONGroupMessage> getGroupMessages(
            @RequestParam(value = "groupId", defaultValue = "0") String groupId){

        List<JSONGroupMessage> result = groupMessageDao.getGroupMessages(groupId);
        return result;
    }

    @RequestMapping(value = "/groupMessage", method = RequestMethod.POST)
    @ResponseBody
    public String addGroupMessage(@RequestBody JSONGroupMessage jsonGroupMessage){
        return groupMessageDao.saveGroupMessage(jsonGroupMessage);
    }
}
