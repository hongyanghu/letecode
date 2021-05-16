package 反转链表2;

import 反转链表.ListNode;

import java.util.List;
import java.util.Stack;

public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode start=new ListNode(0);
        start.next=head;
        ListNode pre=start;
        ListNode post=null;
        Stack stack = new Stack();
        int count=0;
        while(head!=null){
            count++;
            if (count<left){
                pre=pre.next;
            }else if (count>=left && count<=right){
                stack.push(head);
            }else{
                post=head;
                break;
            }
            head=head.next;
        }
        //反转子链表

        while(!stack.isEmpty()){
            ListNode pop = (ListNode) stack.pop();
            pre.next=pop;
            pre=pop;
        }
        pre.next=post;
        return start.next;
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
        Solution solution= new Solution();
        ListNode listNode = solution.reverseBetween(listNode1,2,4);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
