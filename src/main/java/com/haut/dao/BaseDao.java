package com.haut.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
@Repository
public class BaseDao<T> {

    @Autowired
    protected HibernateTemplate hibernateTemplate;
    @Autowired
    protected SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T model) {
        hibernateTemplate.save(model);
    }

    public void update(T model) {
        hibernateTemplate.update(model);
    }

    public void delete(T model) {
        hibernateTemplate.delete(model);
    }

}
