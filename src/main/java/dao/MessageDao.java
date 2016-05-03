package dao;

import model.Conversation;
import model.Message;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class MessageDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<Message> getMessages(String receiverId){
        List<Message> messageList = new ArrayList<Message>();
        //folosim Message, numele entitatii, nu al tabelului. csf n-ai csf
        String query = "select m from Message m where m.receiverId=?";
        Object[] queryParam = {receiverId};
        System.out.println(hibernateTemplate.find(query, queryParam));

        return null;
    }

    public void saveMessage(String text, String senderId, String receiverId) {
        Message message = new Message();

        message.setText(text);
        message.setSenderId(senderId);
        message.setReceiverId(receiverId);

        hibernateTemplate.save(message);
    }
}
