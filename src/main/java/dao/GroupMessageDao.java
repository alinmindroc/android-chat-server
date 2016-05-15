package dao;

import JSON_objects.JSONGroupMessage;
import model.GroupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class GroupMessageDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<JSONGroupMessage> getGroupMessages(String groupId){
        //folosim Message, numele entitatii, nu al tabelului. csf n-ai csf
        String query = "select m from GroupMessage m where m.groupId=?";
        Object[] queryParam = {groupId};

        return (List<JSONGroupMessage>) hibernateTemplate.find(query, queryParam);
    }

    public String saveGroupMessage(JSONGroupMessage jsonGroupMessage) {
        GroupMessage message = new GroupMessage();

        message.setText(jsonGroupMessage.getText());
        message.setSenderId(jsonGroupMessage.getSenderId());
        message.setSenderName(jsonGroupMessage.getSenderName());
        message.setGroupId(jsonGroupMessage.getGroupId());

        hibernateTemplate.save(message);

        return "true";
    }
}
