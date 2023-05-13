package com.sxg.dance;

import com.sxg.Understand;
import com.sxg.base.ListNode;

/**
 * 876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 *
 * @author sxg
 * create in 2021/11/27
 */
@Understand
@Deprecated
public class MiddleNode {


    /**
     * 快慢指针
     * <p>
     * 时间复杂度：O(N)O(N)，其中 NN 是给定链表的结点数目。
     * <p>
     * 空间复杂度：O(1)O(1)，只需要常数空间存放 slow 和 fast 两个指针。
     *
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        // 这里应该是没有环的情况，是否要先声明
        while (fast != null && fast.next != null) { // todo 这个条件是重点，防止npe
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}


