package com.haut.util;

import com.haut.dao.StudentDao;
import com.haut.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
@Component
public class BatchUtil implements Runnable {

    @Autowired
    StudentDao studentDao;
    Random random = new Random();

    public void run() {
        for (int i = 0; i < 10; i++) {
            Student student = new Student(RandomName.getRandomString(5), random.nextInt(30));
            studentDao.save(student);
        }
    }
}
