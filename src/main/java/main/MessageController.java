package main;

import dao.MessageDao;
import model.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public List<Message> getMessages(@RequestParam(value = "receiverId", defaultValue = "0") String receiverId) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        MessageDao dao = ctx.getBean(MessageDao.class);

        return dao.getMessages(receiverId);
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public void postMessage(@RequestBody JSONMessage message){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        MessageDao dao = ctx.getBean(MessageDao.class);
        dao.saveMessage(message.getContent(), message.getSenderId(), message.getReceiverId());
    }
}
