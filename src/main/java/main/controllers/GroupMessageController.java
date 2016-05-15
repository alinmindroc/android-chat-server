package main.controllers;

import JSON_objects.JSONGroupMessage;
import dao.GroupMessageDao;
import main.AppConfig;
import model.GroupMessage;
import model.Message;
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

    @RequestMapping(value = "/prettyGroupConversation", method = RequestMethod.GET)
    public String getPrettyConversation(
            @RequestParam(value = "groupId", defaultValue = "0") String groupId){

        List<GroupMessage> messages = groupMessageDao.getGroupDBMessages(groupId);

        String result = "<ul style='list-style-type: none; margin: 0; padding: 0'>";

        for(GroupMessage m : messages){
            result += "<li style='color:#0065BC'><b>" + m.getSenderName() + "</b>: " + m.getText() + "</li>";
            result += "<br>";
        }

        result += "</ul>";

        return result;
    }

}
