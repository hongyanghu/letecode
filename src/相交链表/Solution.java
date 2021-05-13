package 相交链表;

import 反转链表.ListNode;

import java.util.LinkedList;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        LinkedList<ListNode> listNodes = new LinkedList<>();
        boolean flag=false;
        while(headA!=null){
            listNodes.add(headA);
            headA=headA.next;
        }
        while(headB!=null){
            if (listNodes.contains(headB)){
                flag=true;
                break;
            }
            headB=headB.next;
        }
        if (!flag){
            return null;
        }else{
            return headB;
        }
    }

    public static void main(String[] args) {

    }
}
