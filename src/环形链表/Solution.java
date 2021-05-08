package 环形链表;

import 反转链表.ListNode;

import java.util.HashSet;

public class Solution {
    public boolean hasCycle(ListNode head){
        ListNode temp=head;
        HashSet<ListNode> listNodes = new HashSet<>();
        while(temp!=null){
            if (!listNodes.add(temp)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    //环问题：快慢指针
    public boolean hasCycle2(ListNode head){

        if (head==null || head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(slow!=fast){
            if (fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
