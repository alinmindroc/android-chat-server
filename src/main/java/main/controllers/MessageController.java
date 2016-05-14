package main.controllers;

import JSON_objects.JSONMessage;
import dao.MessageDao;
import main.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    private AnnotationConfigApplicationContext ctx;
    private MessageDao messageDao;

    public MessageController(){
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        messageDao = ctx.getBean(MessageDao.class);
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public List<JSONMessage> getMessages(
            @RequestParam(value = "receiverId", defaultValue = "0") String receiverId,
            @RequestParam(value = "senderId", defaultValue = "0") String senderId) {

        List<JSONMessage> result = messageDao.getMessages(senderId, receiverId);
        return result;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public void addMessage(@RequestBody JSONMessage jsonMessage){
        messageDao.addMessage(jsonMessage);
    }
}
