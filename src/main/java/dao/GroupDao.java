package dao;

import JSON_objects.JSONGroup;
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

        List<JSONGroup> allGroups = (List<JSONGroup>) hibernateTemplate.find(query);
        //de filtrat doar grupurile care contin memberId

        ArrayList<JSONGroup> filteredGroups = new ArrayList<>();

        for(JSONGroup g: allGroups){
            if(g.getMembersId().contains(memberId)){
                filteredGroups.add(g);
            }
        }

        return filteredGroups;
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
