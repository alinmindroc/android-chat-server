package main.controllers;

import JSON_objects.JSONGroup;
import dao.GroupDao;
import main.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupController {
    private AnnotationConfigApplicationContext ctx;
    private GroupDao groupDao;

    public GroupController(){
        ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

        groupDao = ctx.getBean(GroupDao.class);
    }

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public List<JSONGroup> getGroups(
            @RequestParam(value = "memberId", defaultValue = "0") String memberId){
        List<JSONGroup> result = groupDao.getGroups(memberId);
        return result;
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    @ResponseBody
    public void addGroup(@RequestBody JSONGroup jsonGroup){
        groupDao.addGroup(jsonGroup);
    }
}
