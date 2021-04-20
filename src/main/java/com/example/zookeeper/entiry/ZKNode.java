package com.example.zookeeper.entiry;

import java.io.Serializable;
import java.util.List;

/**
 * @author lixiang
 * @date 2021/4/15 9:28
 */
public class ZKNode implements Serializable {
    private static final long serialVersionUID = -7611974591378459856L;
    private String key;
    private String value;
    private String parentPath;
    private List<String> childNodes;

    public ZKNode() {
    }

    public ZKNode(String key, String parentPath) {
        this.key = key;
        this.parentPath = parentPath;
    }

    public ZKNode(String key, String value, String parentPath) {
        this.key = key;
        this.value = value;
        this.parentPath = parentPath;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public List<String> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<String> childNodes) {
        this.childNodes = childNodes;
    }

    @Override
    public String toString() {
        return "ZKNode{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                ", parentPath='" + parentPath + '\'' +
                ", childNodes=" + childNodes +
                '}';
    }
}
