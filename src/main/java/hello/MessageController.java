package hello;

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
    public void postMessage(@RequestBody JSONMessage message) {
        System.out.println("post: " + message);
    }
}
