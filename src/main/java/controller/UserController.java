package controller;

import common.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pojo.User;
import service.UserManager;

@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserManager manager;
    @RequestMapping(method = RequestMethod.GET)
    public Page loadAllUsers(Integer draw, @RequestParam(value = "search[value]") String search, Integer start, Integer length,
                             @RequestParam(value = "order[0][column]")Integer columnNo, @RequestParam(value = "order[0][dir]")String columnDir){
        System.out.println(draw + search + start +  +columnNo + columnDir);
        Page<User> page = manager.loadAllUsers(search,start,length, columnNo, columnDir);
        page.setDraw(draw);
        return page;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User registNewUser(@RequestBody User user){
        return manager.registUser(user);
    }
}
