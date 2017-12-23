package com.haut.aopdao;

import com.haut.model.Student;
import com.haut.writeread.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author xxx_xx
 * @date 2017/12/22
 */
@Repository
public class UserDao {

    @Autowired
    HibernateTemplate hibernateTemplate;
    @Autowired
    SessionFactory sessionFactory;

    public void save(User user) {
        hibernateTemplate.save(user);
    }


    public User queryById(long id) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where id = :id")
                .setLong("id", id)
                .uniqueResult();
    }
}
