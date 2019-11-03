package 剑指offer编程题_第二版.test14_链表中倒数第k个结点;

/*
输入一个链表，输出该链表中倒数第k个结点
 */


public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p1=head;
        ListNode p2=p1;
        int i;
        for (i=0; p2!=null; i++){
            if(i>=k){
                p1=p1.next;
            }
            p2=p2.next;
        }
        return i >= k ? p1 : null;
    }
}
