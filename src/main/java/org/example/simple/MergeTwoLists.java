package org.example.simple;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 *
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 *
 * 提示：
 *
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 *
 */
public class MergeTwoLists {


    public static void main(String[] args) {
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode list1 = new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(4))));

        ListNode list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        ListNode listNode = mergeTwoLists.mergeTwoLists(list1, list2);

        System.out.println(listNode);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = null;

        List<Integer> l1 = new LinkedList<>();
        int flag = 0;
        while (list1!= null && list2!= null) {
            if (list1.val <= list2.val) {
                l1.add(list1.val);
                l1.add(list2.val);
            } else {
                l1.add(list2.val);
                l1.add(list1.val);
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        if (list1 != null) {
            do {
                l1.add(list1.val);
                list1 = list1.next;
            } while (list1 != null);

        }
        if (list2 != null) {
            do {
                l1.add(list2.val);
                list2 = list2.next;
            } while (list2 != null);
        }
        flag = l1.size();
        Collections.sort(l1);

        for (int i = 0; i < flag; i++) {
            if (listNode == null) {
                listNode = new ListNode(l1.get(flag-i-1));
            } else {
                listNode = new ListNode(l1.get(flag-i-1), listNode);
            }
        }

        return listNode;
    }

}
