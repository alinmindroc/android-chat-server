package main.controllers;

import JSON_objects.JSONMessage;
import JSON_objects.JSONNotification;
import dao.MessageDao;
import dao.NotificationDao;
import main.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {
    private AnnotationConfigApplicationContext ctx;
    private NotificationDao notificationDao;

    public NotificationController(){
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        notificationDao = ctx.getBean(NotificationDao.class);
    }

    @RequestMapping(value = "/notification", method = RequestMethod.GET)
    public List<JSONNotification> getNotifications(
            @RequestParam(value = "recipientId", defaultValue = "0") String recipientId) {

        List<JSONNotification> result = notificationDao.getNotifications(recipientId);
        return result;
    }

    @RequestMapping(value = "/notification", method = RequestMethod.POST)
    @ResponseBody
    public String addNotification(@RequestBody JSONNotification jsonNotification){
        return notificationDao.addNotification(jsonNotification);
    }

    @RequestMapping(value = "/removeNotification", method = RequestMethod.GET)
    public String removeNotification(
            @RequestParam(value = "notificationId", defaultValue = "0") int notificationId) {

        return notificationDao.removeNotification(notificationId);
    }


    @RequestMapping(value = "/markNotificationAccepted", method = RequestMethod.GET)
    public String markNotificationAccepted(
            @RequestParam(value = "notificationId", defaultValue = "0") int notificationId) {

        return notificationDao.markNotificationAccepted(notificationId);
    }
}
