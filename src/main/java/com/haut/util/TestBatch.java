package com.haut.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xxx_xx
 * @date 2017/12/21
 */
public class TestBatch {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        MysqlBatch mysqlBatch = new MysqlBatch();
        for (int i = 0; i < 10; i++) {
            executorService.submit(mysqlBatch);
        }
        executorService.shutdown();
    }
}
