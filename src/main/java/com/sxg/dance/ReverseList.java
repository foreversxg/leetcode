package com.sxg.dance;

import com.sxg.base.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * @author sxg create in 2021/11/26
 */
@Deprecated
public class ReverseList {

    /**
     * 问题分解
     *      1、将每个节点前后倒置
     *      2、返回新的头节点
     */

    /**
     * 时间复杂度：O(n)，其中 nn 是链表的长度。需要遍历链表一次。
     * <p>
     * 空间复杂度：O(1)。
     *
     * @param head
     * @return
     */
    public ListNode reverseList_1(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 这里一定要返回pre
        return pre;
    }


    /**
     * 时间复杂度：O(n)，其中 n 是链表的长度。需要对链表的每个节点进行反转操作。
     * <p>
     * 空间复杂度：O(n)，其中 n 是链表的长度。空间复杂度主要取决于递归调用的栈空间，最多为 nn 层。
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { // todo
            return head;
        }
        ListNode newNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
