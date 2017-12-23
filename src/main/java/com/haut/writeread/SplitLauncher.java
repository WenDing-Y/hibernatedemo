package com.haut.writeread;

import com.haut.aopdao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xxx_xx
 * @date 2017/12/22
 */
public class SplitLauncher {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springContext-master-slave.xml");
        context.start();
        UserDao userDao = (UserDao) context.getBean("userDao");
       // User user = new User("mysql1");
       //  userDao.save(user);
        System.out.println(userDao.queryById(1L));
        context.stop();
    }
}
