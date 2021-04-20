package com.example.zookeeper.util;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author lixiang
 * @date 2021/4/15 9:39
 */
public class ZKLoader {

    private static final int BASE_SLEEP_TIME = 1000;
    private static final int MAX_RETRIES = 3;

    private static volatile Map<String,CuratorFramework> curatorMap = new ConcurrentHashMap<>();


    public static CuratorFramework getConnection(String address){
        if (curatorMap.get(address) != null){
            return curatorMap.get(address);
        }
        return createConnection(address);
    }

    private static CuratorFramework createConnection(String address){
        //重试策略 1s 重试3次
        RetryPolicy policy = new ExponentialBackoffRetry(BASE_SLEEP_TIME,MAX_RETRIES);
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(address)
                .connectionTimeoutMs(3*1000)
                .sessionTimeoutMs(30*1000)
                .retryPolicy(policy)
                .build();
        curatorFramework.start();
        //
        try {
            curatorFramework.blockUntilConnected(3, TimeUnit.SECONDS);
            if (curatorFramework.getZookeeperClient().isConnected()){
                System.out.println("zookeeper 连接成功");
                curatorMap.put(address,curatorFramework);
                return curatorFramework;
            }
        } catch (InterruptedException e) {
            System.out.println("zookeeper 连接失败");
            e.printStackTrace();
        }
        //失败情况
        curatorFramework.close();
        throw new RuntimeException("连接zookeeper服务: "+address+" 失败!");
    }

    public static void disConnect(String address){
        if (curatorMap.get(address) == null){
            System.out.println("未连接到zookeeper： "+address);
            return;
        }
        curatorMap.get(address).close();
        curatorMap.remove(address);
    }

}
