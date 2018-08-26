package service.impl;

import common.Page;
import dao.impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import service.UserManager;

import java.util.List;
@Service
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDaoImpl impl;
    @Transactional
    @Override
    public User registUser(User user) {
        return impl.addUser(user);
    }

    @Override
    public Page<User> loadAllUsers(String search, Integer start, Integer length,Integer columnNO,String columnDir) {
        Page<User> page = new Page<>();
        int sum = impl.getCount();
        int filterSum = impl.getFilterCount(search);
        if (filterSum == 0){
            page.setRecordsFiltered(sum);
        }else{
            page.setRecordsFiltered(filterSum);
        }
        page.setRecordsTotal(sum);
        page.setData(impl.getUsers(search,start,length,columnNO,columnDir));
        return page;
    }
}
