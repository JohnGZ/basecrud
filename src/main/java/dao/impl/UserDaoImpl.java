package dao.impl;

import common.ColumnNOMappingTool;
import dao.UserDao;
import org.springframework.stereotype.Repository;
import pojo.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext(name = "em")
    private EntityManager em;
    @Override
    public User addUser(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public List<User> getUsers(String search,Integer start,Integer length,Integer columnNO,String columnDir) {
        String column = ColumnNOMappingTool.ColumnNO2ColumnName(columnNO);
        String jpql;
        if (!search.equals("")){
            jpql = "FROM pojo.User u WHERE u.name like"+ " \'%"+search+"%\'"
                    +" order by u." + column +" " + columnDir;
        }else {
            jpql = "FROM pojo.User u"
                    +" order by u." + column +" " + columnDir;
        }
        System.out.println(jpql);
        return em.createQuery(jpql)
                .setFirstResult(start)
                .setMaxResults(length)
                .getResultList();
    }

    @Override
    public Integer getCount() {
        String jpql = "SELECT count(*) FROM pojo.User";
        return ((Long)em.createQuery(jpql).getSingleResult()).intValue();
    }

    @Override
    public Integer getFilterCount(String search) {
        if (search.equals("")){
            return 0;
        }else {
            String jpql = "SELECT count(*) FROM pojo.User u WHERE u.name like"+ " \'%"+search+"%\'";
            return ((Long)em.createQuery(jpql)
                    .getSingleResult()).intValue();
        }
    }
}
