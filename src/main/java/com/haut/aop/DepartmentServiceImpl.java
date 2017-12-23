package com.haut.aop;

import org.springframework.stereotype.Service;

/**
 * @author xxx_xx
 * @date 2017/12/22
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    public void addDepartment() {
        System.out.println("增加部门");
    }
}
