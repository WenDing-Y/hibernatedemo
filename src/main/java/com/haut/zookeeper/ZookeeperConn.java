package com.haut.zookeeper;


import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author xxx_xx
 * @date 2018/1/3
 */
public class ZookeeperConn implements Watcher {

    private ZooKeeper keeper;
    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    public ZookeeperConn() throws IOException {
        keeper = new ZooKeeper("xx:2181", 5000, this);
    }

    public void process(WatchedEvent event) {
        if (Event.KeeperState.SyncConnected == event.getState()) {
            if (Event.EventType.None == event.getType() && null == event.getPath()) {
                connectedSemaphore.countDown();
                System.out.println("session conn success");
                try {
                    keeper.exists("/user", true);
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (Event.EventType.NodeCreated == event.getType()) {
                System.out.println("success create znode");
            } else if (Event.EventType.NodeDataChanged == event.getType()) {
                System.out.println("success change znode: " + event.getPath());
            } else if (Event.EventType.NodeDeleted == event.getType()) {
                System.out.println("success delete znode");
            } else if (Event.EventType.NodeChildrenChanged == event.getType()) {
                System.out.println("NodeChildrenChanged");
            }

        }
    }

    public void createNode() {
        try {
            keeper.create("/user", "hello".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
          //  keeper.exists("/user", true);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void changeNode() throws KeeperException, InterruptedException {
        keeper.setData("/user","ef".getBytes(),-1);
    }

    public void createChildNode() {
        try {
            keeper.create("/user/child", "world".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteNode() {
        try {
            keeper.delete("/user", -1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {
        ZookeeperConn conn = new ZookeeperConn();
        connectedSemaphore.await();
        conn.createNode();
        conn.changeNode();
      //  conn.deleteNode();
       // conn.createChildNode();
        Thread.sleep(Integer.MAX_VALUE);
    }
}
