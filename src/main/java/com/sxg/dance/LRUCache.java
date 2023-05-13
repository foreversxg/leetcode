package com.sxg.dance;

import com.sxg.base.LinkedNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sxg
 * create in 2021/11/28
 */
public class LRUCache {

    private Map<String, LinkedNode> cache = new HashMap<>();

    private LinkedNode head;
    private LinkedNode tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public void put(String key, String value) {

        LinkedNode node = cache.get(key);
        if (node == null) {
            LinkedNode newNode = new LinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if (size > capacity) {
                // 超出容量需要移除尾部节点
                LinkedNode delNode = removeTail();
                // 记得更新cache
                cache.remove(delNode.key);
                size--;

            }
        } else {
            //put也要更新热度cache
            node.value = value;
            moveToHead(node);
        }
    }

    private LinkedNode removeTail() {
        LinkedNode node = tail.pre;
        removeNode(node);
        return node;
    }

    public String get(String key) {
        LinkedNode node = cache.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    private void moveToHead(LinkedNode node) {
        // 分为两步，先移除所在位置，然后插入到队列头部 todo
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(LinkedNode node) {
        head.next.pre = node;
        node.next = head.next;
        head.next = node;
        node.pre = head;
    }

    private void removeNode(LinkedNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

}
