package linkedlist;

public class MergeTwoSorted {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    public static ListNode nonRecur(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                dummy.next = l1; // 先把head 那邊串上去 較小的l1.val
                l1 = l1.next; //l1 更新為 l1.next
            }
            else
            {
                dummy.next = l2; //因l2.val較小 所以dum.next串到l2 同時代表 head 也會跟著一起串
                l2 = l2.next; // 因為已經排入l2.val 所以再更新l2為l2.next
            }
            dummy = dummy.next; //dum指向l1.next或l2.next
        }

        if(l1 != null)
        {
            dummy.next = l1;
        }
        else
        {
            dummy.next = l2;
        }

        return head.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(21);
        l1.next.next = new ListNode(31);

        ListNode l2 = new ListNode(12);
        l2.next = new ListNode(13);
        l2.next.next = new ListNode(14);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        nonRecur(l1, l2);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
