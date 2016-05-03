package main;

import dao.ConversationDao;
import dao.PersonDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class MessageController {
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public JSONMessage getMessage(@RequestParam(value = "receiverId", defaultValue = "0") String receiverId) {
        System.out.println("get: " + receiverId);
        return new JSONMessage("asd", new Date(), "1", "2", "alin", "asd");
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    @ResponseBody
    public String postMessage(@RequestBody JSONMessage message) {
        System.out.println("post: " + message);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        ConversationDao pdao = ctx.getBean(ConversationDao.class);
        pdao.saveConversation(message.getContent());

        return "Done";
    }
}
