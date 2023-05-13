package com.sxg.dance;

import com.sxg.base.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. 回文链表
 * <p>
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @author sxg
 * create in 2021/11/27
 */
public class IsPalindrome {

    // 也可以使用翻转链表的方式来处理

    /**
     * 问题分解
     * 1.构造一个对称的结构
     * 2.收尾对比
     */


    /**
     * 双指针
     * <p>
     * 时间复杂度：O(n)O(n)，其中 nn 指的是链表的元素个数。
     * 第一步： 遍历链表并将值复制到数组中，O(n)O(n)。
     * 第二步：双指针判断是否为回文，执行了 O(n/2)O(n/2) 次的判断，即 O(n)O(n)。
     * 总的时间复杂度：O(2n) = O(n)O(2n)=O(n)。
     * 空间复杂度：O(n)O(n)，其中 nn 指的是链表的元素个数，我们使用了一个数组列表存放链表的元素值。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int start = 0;
        int end = list.size() - 1;
        while (start < end) { // todo 推出条件
            if (list.get(start).getValue() != list.get(end).getValue()) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
