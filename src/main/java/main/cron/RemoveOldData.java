package main.cron;

import dao.GroupMessageDao;
import dao.MessageDao;
import main.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Configuration;

import java.util.Calendar;

@Component
@Configuration
@EnableScheduling
public class RemoveOldData {
    private AnnotationConfigApplicationContext ctx;
    private GroupMessageDao groupMessageDao;
    private MessageDao messageDao;

    public RemoveOldData(){
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        groupMessageDao = ctx.getBean(GroupMessageDao.class);
        messageDao = ctx.getBean(MessageDao.class);
    }


    // every month on the first day at 00:00:00, delete messages which are older one month
    // @Scheduled(cron = "* * * * * ?") //every second: for testing purposes
    @Scheduled(cron = "0 0 0 1 * ?")
    public void deleteOldMessages() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);

        //delete old private messages
        messageDao.removeMessagesOlderThan(calendar.getTime());

        //delete old group messages
        groupMessageDao.removeGroupMessagesOlderThan(calendar.getTime());
    }
}
