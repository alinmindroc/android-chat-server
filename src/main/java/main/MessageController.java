package main;

import dao.MessageDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public JSONMessage postMessage(@RequestBody JSONMessage message){
        messageDao.saveMessage(message.getContent(), message.getSenderId(), message.getReceiverId(), message.getSenderName(), message.getReceiverName());

        return new JSONMessage("asd", new Date(), "1", "2", "3", "4");
    }
}
