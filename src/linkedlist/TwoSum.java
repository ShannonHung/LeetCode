package linkedlist;

public class TwoSum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); //因為ans 會一直替換ans.next
        ListNode ans = head;
        int quotient = 0;
        while(l1!=null || l2!=null || quotient>0){
            int sum = (l1 != null? l1.val: 0) + (l2 != null ? l2.val: 0) + quotient;
            ans.next = new ListNode(sum % 10);
            quotient = sum /10; //取得商數 下一個做進位
            l1 = (l1 == null ? l1: l1.next);
            l2 = (l2 == null ? l2: l2.next);
            ans = ans.next;
        }
        return head.next;
//        ListNode head = new ListNode(0);
//        ListNode result = head;
//        int carry = 0;
//
//        while (l1 != null || l2 != null || carry > 0) {
//            int resVal = (l1 != null? l1.val : 0) + (l2 != null? l2.val : 0) + carry;
//            result.next = new ListNode(resVal % 10);
//            carry = resVal / 10;
//            l1 = (l1 == null ? l1 : l1.next);
//            l2 = (l2 == null ? l2 : l2.next);
//            result = result.next;
//        }
//
//        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9,new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        addTwoNumbers(l1, l2);
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
