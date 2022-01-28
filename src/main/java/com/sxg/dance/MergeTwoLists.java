package com.sxg.dance;

import com.sxg.base.ListNode;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 *
 * @author sxg
 * create in 2021/11/28
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode<Integer, Integer> l1, ListNode<Integer, Integer> l2) {

        // 把链表头记录下来
        ListNode<Integer, Integer> pre = new ListNode<>(0);
        ListNode node = pre;
        while (l1 != null && l2 != null) {
            if (l1.value > l2.value) {
                node.next = l2;
                l2 = l2.next;
            } else {
                node.next = l1;
                l1 = l1.next;
            }
            // 这一步不能忘
            node = node.next;
        }
        // 最后统一收编
        node.next = l1 == null ? l2 : l1;
        return pre.next;
    }
}
