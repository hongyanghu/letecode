package 二叉树的锯齿形层序遍历;

import java.util.*;


class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {



        List<List<Integer>> lists = new ArrayList<>();
        if (root==null){
            return lists;
        }

        Queue queue= new LinkedList<TreeNode>();

        queue.offer(root);

        boolean isOrderLeft=true;

        while(!queue.isEmpty()){
            Deque<Integer> list = new LinkedList<Integer>();

            int size = queue.size();

            for (int i=0;i<size;i++){
                TreeNode poll = (TreeNode) queue.poll();

                if (isOrderLeft){
                    list.addLast(poll.val);
                }else{
                    list.addFirst(poll.val);
                }
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            lists.add(new LinkedList<Integer>(list));
            isOrderLeft=!isOrderLeft;
        }

        return lists;
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<Integer>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode lever1l = new TreeNode(9);
        TreeNode lever1r = new TreeNode(20);
        TreeNode rightl = new TreeNode(15);
        TreeNode rightr = new TreeNode(7);
        root.left=lever1l;
        root.right=lever1r;
        lever1r.left=rightl;
        lever1r.right=rightr;
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.zigzagLevelOrder(root);

    }
}
