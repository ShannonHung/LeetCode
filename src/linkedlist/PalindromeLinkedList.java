package linkedlist;

public class PalindromeLinkedList {
    static ListNode front;
    public static boolean isPalindrome(ListNode head) {
        if(head!=null){
            if(!isPalindrome(head.next)) return false;
            if(front.val!=head.val) return false;
            front = front.next;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(1);

        front = l1;
        isPalindrome(l1);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
