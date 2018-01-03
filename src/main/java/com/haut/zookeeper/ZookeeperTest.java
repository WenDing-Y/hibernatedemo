package com.haut.zookeeper;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * @author xxx_xx
 * @date 2018/1/3
 */
public class ZookeeperTest {

    private ZooKeeper keeper;
    MyWatcher watcher = new MyWatcher();

    public ZookeeperTest() throws IOException {
        keeper = new ZooKeeper("xx:2181", 5000, watcher);
    }


    public void createNode() {
        try {
            keeper.create("/user", "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            keeper.register(watcher);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, InterruptedException {
        ZookeeperTest test = new ZookeeperTest();
        test.createNode();
        Thread.sleep(Integer.MAX_VALUE);
    }

}
