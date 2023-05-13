package com.sxg.dance;

import com.sxg.base.ListNode;

/**
 * 141. 环形链表
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 *
 * @author sxg
 * create in 2021/11/27
 */
public class LycleSycle {

    /**
     * 问题分解
     *  1.快慢指针
     *  2.退出条件
     */


    /**
     * 时间复杂度：O(N)O(N)，其中 NN 是链表中的节点数。
     * <p>
     * 当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
     * <p>
     * 当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 NN 轮。
     * <p>
     * 空间复杂度：O(1)O(1)。我们只使用了两个指针的额外空间。
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next; // 这里快指针初始化就要移动，不然会影响下面等式判断
        while (slow != fast) {
            if (fast == null || fast.next == null) { // why
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
