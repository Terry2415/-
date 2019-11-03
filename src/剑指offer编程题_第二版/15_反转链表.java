package 剑指offer编程题_第二版.test15_反转链表;

/*
输入一个链表，反转链表后，输出新链表的表头。

 */

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while( head != null){
            next = head.next;
            head.next=pre;
            pre= head;
            head=next;
        }
        return pre;
    }
}
