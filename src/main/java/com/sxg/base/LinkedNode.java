package com.sxg.base;

/**
 * @author sxg
 * create in 2021/11/28
 */
public class LinkedNode {

    public String key;
    public String value;
    public LinkedNode pre;
    public LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
