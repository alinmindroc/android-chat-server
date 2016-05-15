package dao;

import JSON_objects.JSONGroup;
import JSON_objects.JSONGroupMessage;
import model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class GroupDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<JSONGroup> getGroups(String memberId) {
        String query = "select g from Group g";

        List<Group> allGroups = (List<Group>) hibernateTemplate.find(query);

        ArrayList<JSONGroup> filteredGroups = new ArrayList<>();

        //filter only groups which contain the specified member id
        for(Group g: allGroups){
            if(g.getMembersId().contains(memberId)){
                filteredGroups.add(new JSONGroup(g.getId(), g.getName(), g.getMembersId()));
            }
        }

        return filteredGroups;
    }

    public String leaveGroup(int groupId, String memberId){
        String query = "select g from Group g where g.id=?";
        Object[] queryParam = {groupId};

        Group group = ((List<Group>) hibernateTemplate.find(query, queryParam)).get(0);

        String[] ids = group.getMembersId().split(":");
        String newMembersId = "";

        for(String id: ids){
            if(id.equals(memberId) == false){
                newMembersId += id + ":";
            }
        }

        group.setMembersId(newMembersId);

        hibernateTemplate.save(group);

        return "true";
    }

    public String addGroup(JSONGroup jsonGroup) {
        Group group = new Group();

        //asteapta o lista de id-uri despartite prin `:`
        group.setMembersId(jsonGroup.getMembersId());
        group.setName(jsonGroup.getName());

        hibernateTemplate.save(group);

        return "true";
    }

}
