package service;

import common.Page;
import pojo.User;

import java.util.List;

public interface UserManager {
    public User registUser(User user);
    public Page<User> loadAllUsers(String search, Integer start, Integer length,Integer columnNO,String columnDir);
}
