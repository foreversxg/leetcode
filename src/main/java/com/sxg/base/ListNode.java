package com.sxg.base;

/**
 * @author sxg
 * create in 2021/8/23
 */
public class ListNode<K, V> {

    public K key;
    public V value;
    public ListNode<K, V> pre, next;

    public ListNode(V value) {
        this.value = value;
    }

    public ListNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public ListNode<K, V> getPre() {
        return pre;
    }

    public void setPre(ListNode<K, V> pre) {
        this.pre = pre;
    }

    public ListNode<K, V> getNext() {
        return next;
    }

    public void setNext(ListNode<K, V> next) {
        this.next = next;
    }
}
