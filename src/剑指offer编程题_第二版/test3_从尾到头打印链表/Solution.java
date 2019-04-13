

/*

    输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */

package 剑指offer编程题_第二版.test3_从尾到头打印链表;
import java.util.ArrayList;
import java.util.Collections;

public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
           this.val = val;
        }
}

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();

        while(listNode!=null){
            list.add(listNode.val);
            listNode = listNode.next;
        }

        Collections.reverse(list);
        return list;
    }
}
