package 合并K个升序链表;


import java.util.PriorityQueue;

class Status implements Comparable<Status>{
    int val;
    ListNode pstr;

    public Status(int val, ListNode pstr) {
        this.val = val;
        this.pstr = pstr;
    }

    @Override
    public int compareTo(Status o) {
        return this.val-o.val;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        return null;
    }
    //分治合并
    public ListNode mergeKLists1(ListNode[] lists){
        return merge(lists,0,lists.length-1);
    }
    public ListNode merge(ListNode[] lists,int l,int r){
        if (l==r){
            return lists[l];
        }
        if (l>r){
            return null;
        }
        int mid=l+r>>1;
        return mergeTwoLists(merge(lists,l,mid),merge(lists,mid+1,r));
    }

    //顺序合并
    public ListNode mergeKLists2(ListNode[] lists) {

        ListNode ans = null;

        for (int i = 0; i < lists.length; i++) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = new ListNode(0, null);
        ListNode temp = start;
        ListNode pNode = list1;
        ListNode qNode = list2;
        while (pNode != null && qNode != null) {
            if (pNode.val < qNode.val) {
                temp.next = pNode;
                temp = pNode;
                pNode = pNode.next;
            } else {
                temp.next = qNode;
                temp = qNode;
                qNode = qNode.next;
            }
        }
        if (pNode == null) {
            temp.next = qNode;
        }
        if (qNode == null) {
            temp.next = pNode;
        }
        return start.next;
    }

    //优先队列
    public ListNode mergeKlist3(ListNode[] lists){
        PriorityQueue<Status> objects = new PriorityQueue<Status>();

        //第一次排序
        for (ListNode node:
             lists) {
            objects.offer(new Status(node.val,node));
        }
        //第二次排序
        ListNode head=new ListNode(0);
        ListNode tail = head;
        while(objects!=null){
            Status poll = objects.poll();
            tail.next=poll.pstr;
            tail=tail.next;
            if (poll.pstr.next!=null){
                objects.offer(new Status(poll.pstr.next.val,poll.pstr.next));
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode1_2 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode4_2 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode4;
        listNode4.next = listNode5;
        listNode1_2.next = listNode3;
        listNode3.next = listNode4_2;
        listNode2.next=listNode6;
        ListNode[] temp={listNode1,listNode1_2,listNode2};
        Solution solution = new Solution();
        ListNode listNode = solution.mergeKLists2(temp);

    }
}
