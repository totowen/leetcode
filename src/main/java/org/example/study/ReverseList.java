package org.example.study;


/**
 * 反转链表
 * 反转一个单链表。
 * 输入: 1->2->3->4->5
 * 输出: 5->4->3->2->1
 * <p>
 * 解法：
 * 1.可以采用while循环遍历，第一次循环，节点的next指向null，防止当前节点丢失，用pre保存已经改变指针的节点,并用next指向下一个节点，用cur表示当前节点。
 * 第一次循环结束后，pre要等于第一个节点，cur要等于第二个节点，next要等于第二个节点。
 * 第二次循环结束后，pre要等于第一个节点指向第二个节点，cur要等于第三个节点，next要等于第三个节点。
 * 每次循环过程中，当前节点需要转变next的指向，指向为pre,并且还要将cur赋值给pre。完成节点的方向调转
 *
 */
public class ReverseList {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode iterate(ListNode head) {
        ListNode pre = null, next, cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode node = iterate(node1);
        System.out.println(node);
    }


}
