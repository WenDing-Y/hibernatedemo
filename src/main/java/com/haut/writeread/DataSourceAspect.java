package com.haut.writeread;

import org.aspectj.lang.JoinPoint;

/**
 * @author xxx_xx
 * @date 2017/12/22
 */
public class DataSourceAspect {

    public void before(JoinPoint joinPoint) {
        if (joinPoint.getSignature().getName().startsWith("query")) {
            DynamicDataSourceHolder.markSlave();
        } else {
            DynamicDataSourceHolder.markMaster();
        }
    }
}
