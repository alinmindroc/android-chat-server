package dao;

import model.Conversation;
import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;

@Transactional
public class ConversationDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    public void saveConversation(String message) {
        Conversation conversation = new Conversation();
        conversation.setId(1);
        conversation.setMessage(message);
        hibernateTemplate.save(conversation);
    }
}
