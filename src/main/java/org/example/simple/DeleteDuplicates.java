package org.example.simple;

import java.util.List;

/**
 * 删除排序列表中的重复元素
 *
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 *
 *
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 *
 * 提示：
 *
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 *
 * 题解：
 * 1.while循环遍历单项链表，当前值与下一个值相等，则head直接指向当前ListNode的next
 */
public class DeleteDuplicates {

    public static void main(String[] args) {

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
        deleteDuplicates.deleteDuplicates(new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(3))))));

        ListNode temp  = new ListNode(1);
        temp.next = new ListNode(1);


    }

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return null;
        }

        int temp = head.val;
        ListNode newHead = new ListNode(temp);
        do {
            if(head.val!=temp){
                newHead = new ListNode(head.val,newHead);
                temp = head.val;
            }
            head = head.next;

        }while (head!=null);

        do {
            head = new ListNode(newHead.val,head);
            newHead = newHead.next;
        }while (newHead!=null);

        return head;

    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
