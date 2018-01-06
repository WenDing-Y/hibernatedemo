package com.haut.hbase.conn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * @author xxx_xx
 * @date 2018/1/6
 * 配置文件只需要hbase-site.xml
 */
public class HbaseUtil {

    private static Connection conn;

    public void init() {
        Configuration config = HBaseConfiguration.create();
        try {
            conn = ConnectionFactory.createConnection(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void queryValues() {
        try {
            Table table = conn.getTable(TableName.valueOf("message"));
            Get get = new Get("1001".getBytes());
            get.addColumn("info".getBytes(), "name".getBytes());
            get.addColumn("info".getBytes(), "age".getBytes());
            Result result = table.get(get);
            for (Cell cell : result.rawCells()) {
                System.out.println(Bytes.toString(CellUtil.cloneValue(cell)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addValues() {
        try {
            Table table = conn.getTable(TableName.valueOf("message"));
            Put put = new Put("1004".getBytes());
            put.addColumn("info".getBytes(), "age".getBytes(), "20".getBytes());
            put.addColumn("info".getBytes(), "name".getBytes(), "win".getBytes());
            table.put(put);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        HbaseUtil hbaseUtil = new HbaseUtil();
        hbaseUtil.init();
        hbaseUtil.queryValues();
        hbaseUtil.addValues();
    }
}
