package main.controllers;

import JSON_objects.JSONMessage;
import dao.MessageDao;
import main.AppConfig;
import model.Message;
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
    public String addMessage(@RequestBody JSONMessage jsonMessage){
        return messageDao.addMessage(jsonMessage);
    }

    @RequestMapping(value = "/prettyConversation", method = RequestMethod.GET)
    public String getPrettyConversation(
            @RequestParam(value = "receiverId", defaultValue = "0") String receiverId,
            @RequestParam(value = "senderId", defaultValue = "0") String senderId) {

        List<Message> messages = messageDao.getDBMessages(senderId, receiverId);

        String result = "<ul style='list-style-type: none; margin: 0; padding: 0'>";

        for(Message m : messages){
            if(m.getSenderId().equals(senderId)){
                result += "<li style='color:#2C9DFF'><b>" + m.getSenderName() + "</b>: " + m.getText() + "</li>";
            } else {
                result += "<li style='color:#FF5722'><b>" + m.getSenderName() + "</b>: " + m.getText() + "</li>";
            }
            result += "<br>";
        }

        result += "</ul>";

        return result;
    }
}
