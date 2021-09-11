package linkedlist;

public class CopyOfTemplate {
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}

