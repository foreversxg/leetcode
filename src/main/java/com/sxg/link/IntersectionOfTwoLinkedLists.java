package com.sxg.link;

import com.sxg.base.ListNode;

/**
 * 160. 相交链表
 *
 * @author sxg create in 2022/2/5
 */
public class IntersectionOfTwoLinkedLists {

    /**
     * 问题分解 相交 返回相交的点 不相交 返回null
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        ListNode res = new IntersectionOfTwoLinkedLists().getIntersectionNode(node1, node4);
        System.out.println(res);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            // 如果两条链表不相交，则会直到PA == PB == null 跳出循环。都会走到最后一个元素的next，即null
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
