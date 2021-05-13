package 合并两个有序链表;

import 反转链表.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode head=listNode;
        while(l1!=null&&l2!=null){
            if (l1.val<l2.val){
                head.next=l1;
                head=l1;
                l1=l1.next;
            }else{
                head.next=l2;
                head=l2;
                l2=l2.next;
            }
        }
        if (l1==null){
            head.next=l2;
        }else if (l2==null){
            head.next=l1;
        }
        return listNode.next;
    }
    public static void main(String[] args) {

    }
}
