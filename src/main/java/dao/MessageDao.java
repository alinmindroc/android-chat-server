package dao;

import main.JSONMessage;
import model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
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

    public void saveMessage(String text, String senderId, String receiverId, String senderName, String receiverName) {
        Message message = new Message();

        message.setText(text);
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);
        message.setSenderName(senderName);
        message.setReceiverName(receiverName);

        hibernateTemplate.save(message);
    }
}
