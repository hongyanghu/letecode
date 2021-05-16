import Struct.TreeNode;

public class Solution {
    //树的深度优先遍历
    //一般都是需要递归操作，要思考递归的出口条件

    public TreeNode ans;

    public boolean dfs(TreeNode root,TreeNode p,TreeNode q){
        if (root==null){
            return false;
        }
        //根左右，前序遍历
        boolean lson=dfs(root.left,p,q);
        boolean rson=dfs(root.right,p,q);

        if ((lson&&rson)||((root.val==p.val||root.val==q.val)&&(lson||rson))){
            ans=root;
        }
        //返回上层的函数，为当前值为p,q或者当前的左右子树包含p,q为true，其他为false
        return (root.val==p.val||root.val==q.val)||lson||rson;
    }


    public static void main(String[] args) {

    }
}
