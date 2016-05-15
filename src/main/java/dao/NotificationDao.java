package dao;

import JSON_objects.JSONMessage;
import JSON_objects.JSONNotification;
import model.Message;
import model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class NotificationDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<JSONNotification> getNotifications(String recipientId){
        //folosim Message, numele entitatii, nu al tabelului. csf n-ai csf
        String query = "select n from Notification n where n.recipientId=?";
        Object[] queryParam = {recipientId};
        return (List<JSONNotification>) hibernateTemplate.find(query, queryParam);
    }

    public String addNotification(JSONNotification jsonNotification) {
        Notification notification = new Notification();

        notification.setAccepted("false");
        notification.setContent(jsonNotification.getContent());
        notification.setRecipientId(jsonNotification.getRecipientId());

        hibernateTemplate.save(notification);

        return "true";
    }

    public String removeNotification(int notificationId){
        hibernateTemplate.bulkUpdate("DELETE Notification n where n.id=?", notificationId);
        return "true";
    }

    public String markNotificationAccepted(int notificationId){
        String query = "select n from Notification n where n.id=?";
        Object[] queryParam = {notificationId};

        Notification notification = ((List<Notification>) hibernateTemplate.find(query, queryParam)).get(0);
        notification.setAccepted("true");

        hibernateTemplate.save(notification);
        return notification.getContent();
    }
}
