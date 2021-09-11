package linkedlist;

public class RemoteNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        // 用假節點當首節點，方便操作
        ListNode node = new ListNode(0);
        node.next = head;


        ListNode slow = node;
        ListNode fast = head;

        // 快指針先跑n個節點
        while(n > 0){
            fast = fast.next;
            n--;
        }

        // 因為快指針已經先跑n點，所以當快指針fast跑完，慢指針slow會在要移除的前一點上
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        if(slow.next == null){
            slow.next = null ;
        } else {
            slow.next = slow.next.next;
        }

        return node.next;
    }

    public static void main(String[] args) {

    }

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
