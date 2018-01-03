package com.haut.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * @author xxx_xx
 * @date 2018/1/3
 */
public class MyWatcher implements Watcher {
    public void process(WatchedEvent event) {
        System.out.println(event);
        if (event.getType() == Event.EventType.NodeCreated) {
            System.out.println("node create");
        }
    }
}
