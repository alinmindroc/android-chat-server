package dao;

import JSON_objects.JSONMessage;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public class MessageDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<JSONMessage> getMessages(String senderId, String receiverId){
        //folosim Message, numele entitatii, nu al tabelului. csf n-ai csf
        String query = "select m from Message m where (m.senderId=? and m.receiverId=?) or (m.receiverId=? and m.senderId=?)";
        Object[] queryParam = {senderId, receiverId, senderId, receiverId};
        return (List<JSONMessage>) hibernateTemplate.find(query, queryParam);
    }

    public List<Message> getDBMessages(String senderId, String receiverId){
        //folosim Message, numele entitatii, nu al tabelului. csf n-ai csf
        String query = "select m from Message m where (m.senderId=? and m.receiverId=?) or (m.receiverId=? and m.senderId=?)";
        Object[] queryParam = {senderId, receiverId, senderId, receiverId};
        return (List<Message>) hibernateTemplate.find(query, queryParam);
    }

    public String addMessage(JSONMessage jsonMessage) {
        Message message = new Message();

        message.setText(jsonMessage.getContent());
        message.setSenderId(jsonMessage.getSenderId());
        message.setReceiverId(jsonMessage.getReceiverId());
        message.setSenderName(jsonMessage.getSenderName());
        message.setReceiverName(jsonMessage.getReceiverName());
        message.setDate(jsonMessage.getDate());

        hibernateTemplate.save(message);

        return "true";
    }

    public void removeMessagesOlderThan(Date date){
        hibernateTemplate.bulkUpdate("DELETE Message m where m.date<?", date);
    }
}
