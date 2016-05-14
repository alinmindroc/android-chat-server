package dao;

import JSON_objects.JSONGroup;
import JSON_objects.JSONGroupMessage;
import model.Group;
import model.GroupMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class GroupDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<JSONGroup> getGroups(String memberId) {
        String query = "select g from Group g";

        List<JSONGroup> allGroups = (List<JSONGroup>) hibernateTemplate.find(query);
        //de filtrat grupurile doar care contin memberId

        return allGroups;
    }

    public void addGroup(JSONGroup jsonGroup) {
        Group group = new Group();

        group.setMembersId(jsonGroup.getMembersId());
        group.setName(jsonGroup.getName());

        hibernateTemplate.save(group);
    }

}
