package com.haut.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xxx_xx
 * @date 2017/12/22
 */
public class AoplLauncher {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springContext-aop.xml");
        context.start();
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentServiceImpl");
        departmentService.addDepartment();
        context.stop();
    }
}
