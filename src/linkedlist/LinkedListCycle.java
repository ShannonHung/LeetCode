package linkedlist;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow = head;
        ListNode fast = head;

        while(slow.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
//        l1.next.next = new ListNode(0);
//        l1.next.next.next = new ListNode(4);
//        l1.next.next.next.next = l1.next;

        System.out.println(hasCycle(l1));
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }
}
