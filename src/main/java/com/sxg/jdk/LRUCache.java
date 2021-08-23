package com.sxg.jdk;

import com.sxg.base.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sxg
 * create in 2021/8/23
 */
public class LRUCache<K, V> {

    private Map<K, ListNode<K, V>> map;
    private ListNode<K, V> head;
    private ListNode<K, V> tail;
    private int size;
    private int limit;

    public LRUCache(int limit) {
        this.map = new HashMap<>();
        this.limit = limit;
    }

    public V get(K key) {
        ListNode<K, V> node = map.get(key);
        if (node == null) {
            return null;
        }
        remove(node);
        addFirst(node);
        return node.getValue();
    }

    public void put(K key, V value) {
        ListNode<K, V> node = new ListNode<>(key, value);
        if (map.containsKey(key)) {
            remove(map.get(key));
            addFirst(node);
            map.put(key, node);
            return;
        }
        addFirst(node);
        map.put(key, node);
    }

    public boolean delete(K key) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            return true;
        }
        return false;
    }

    private void addFirst(ListNode<K, V> node) {
        if (head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        if (size >= limit) {
            remove(tail);
        }
        node.setNext(head);
        head.setPre(node);
        head = node;
        size++;
    }

    private void remove(ListNode<K, V> node) {

        if (node.getPre() != null) {
            node.getPre().setNext(node.getNext());
        }
        if (node.getNext() != null) {
            node.getNext().setPre(node.getPre());
        }
        if (node == head) {
            head = node.getNext();
        }
        if (node == tail) {
            tail = node.getPre();
        }
        size--;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode<K, V> node = head;
        while (node != null) {
            result.append(node.getValue()).append(",");
            node = node.getNext();
        }
        return result.toString().substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(5);
        cache.put(1, 1);
        System.out.println(cache.toString());
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        cache.put(5, 5);
        System.out.println(cache.toString());
        cache.put(6, 6);
        System.out.println(cache.toString());
        cache.put(7, 7);
        cache.put(8, 8);
        cache.put(9, 9);
        System.out.println(cache.toString());
        cache.get(5);
        System.out.println(cache.toString());
        cache.get(8);
        System.out.println(cache.toString());
    }
}
