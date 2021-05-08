package 反转链表;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//使用栈的思想，后进先出
//第一个节点指向为null
public class Solution {


    public static ListNode reverseList(ListNode head){
        ListNode pre=null;
        ListNode cur=head;
        while(cur !=null){
            ListNode next= cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public static ListNode reverseList1(ListNode head){

        if (head==null){
            return head;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        ListNode heads = stack.pop();
        ListNode cur=heads;
        while(!stack.isEmpty()){
            ListNode pop = stack.pop();
            cur.next=pop;
            cur=pop;
        }
        cur.next=null;
        return heads;
    }

    public static void main(String[] args) {
        ListNode listNode1=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        ListNode listNode3=new ListNode(3);
        ListNode listNode4=new ListNode(4);
        ListNode listNode5=new ListNode(5);
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode5;
        ListNode listNode = Solution.reverseList1(listNode1);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

}
