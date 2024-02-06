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

    /**
     * 递归方法实现，返回的当前节点的下一个节点的子链表反转结果后，
     * 当前节点和当前节点的下个节点调换指针方向后，
     * 递归返回值也会因为指针变化而变化，因为对象的地址是固定的，所以改变每层递归两个元素之间的指针指向就可以改变原来的方向
     * @param head
     * @return
     */
    public static ListNode recursion(ListNode head){
        //这是递归的终止条件。如果链表为空或只有一个节点，就直接返回该节点，因为反转一个空链表或只有一个节点的链表时，不会改变链表的结构。
        if(head==null||head.next==null){
            return head;
        }
        //通过递归调用，获取以当前节点的下一个节点为头的子链表的反转结果。
        ListNode recursion = recursion(head.next);
        //将当前节点的下一个节点的next指针指向当前节点，实现了当前节点与下一个节点的交换，从而完成了链表的反转。
        head.next.next=head;
        // 将当前节点的next指针置为null，断开原来指向下一个节点的链接，防止形成环。
        head.next = null;

        //返回反转后的链表的头节点，这是递归的出口。
        return recursion;

    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
//        ListNode node = iterate(node1);
        ListNode node = recursion(node1);
        System.out.println(node);
    }


}
