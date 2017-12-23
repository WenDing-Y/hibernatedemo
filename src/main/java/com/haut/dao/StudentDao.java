package com.haut.dao;

import com.haut.model.Student;
import org.springframework.stereotype.Repository;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
@Repository
public class StudentDao extends BaseDao {

    public Student queryById(long id) {
        return (Student) getSession().createQuery("from Student where id = :id")
                .setLong("id", id)
                .uniqueResult();
    }
}
