package dao;

import pojo.User;

import java.util.List;

public interface UserDao {
    public User addUser(User user);
    public List<User> getUsers(String search,Integer start,Integer length,Integer columnNO,String columnDir );
    public Integer getCount();
    public Integer getFilterCount(String search);
}
