package dao;
import javax.transaction.Transactional;

import model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
@Transactional
public class PersonDao {
    @Autowired
    private HibernateTemplate  hibernateTemplate;
    public void savePerson(String name) {
        Person person = new Person();
        person.setId(1);
        person.setName(name);
        hibernateTemplate.save(person);
    }
}