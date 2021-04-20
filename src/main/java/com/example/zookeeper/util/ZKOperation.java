package com.example.zookeeper.util;

import com.example.zookeeper.entiry.ZKNode;
import org.apache.curator.framework.CuratorFramework;

import java.util.List;

/**
 * @author lixiang
 * @date 2021/4/15 10:32
 */
public class ZKOperation {
    public static final String SEPARATOR = "/";
    private CuratorFramework client=null;

    public ZKNode getNode(String address, String parentPath, String key){
        client = ZKLoader.getConnection(address);
        ZKNode node = new ZKNode(key,parentPath);


        return node;
    }
    public ZKNode getRootNode(String address) throws Exception {
        client = ZKLoader.getConnection(address);
        ZKNode root = new ZKNode("","");
        byte[] bytes = client.getData().forPath(""+SEPARATOR+"");
        root.setValue(new String(bytes));

        List<String> childs = client.getChildren().forPath(""+SEPARATOR+"");
        if (childs != null){
            root.setChildNodes(childs);
        }
        return root;
    }

    public static void main(String[] args) throws Exception {
        ZKOperation operation = new ZKOperation();
        ZKNode root = operation.getRootNode("127.0.0.1:2181");
        System.out.println();
    }
}
