package linkedlist;

import org.w3c.dom.NodeList;

import java.util.LinkedList;

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            //先預備下下組
            ListNode temp = curr.next;
            //先跟目前的答案串好
            curr.next = prev;
            //就納入排好行列
            prev = curr;
            //curr再換下一組沒排好的
            curr = temp;
        }
        // fix head
        head = prev;

        return head;
    }
    public static ListNode recurVersion(ListNode head){
        // case1: empty list
        if (head == null) return head;
        // case2: only one element list
        if (head.next == null) return head;
        // case3: reverse from the rest after head
        ListNode newHead = recurVersion(head.next);
        // reverse between head and head->next 後面指向前面
        head.next.next = head;
        // unlink list from the rest 前面斷開
        head.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        recurVersion(head);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
