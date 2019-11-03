package 剑指offer编程题_第二版.test17_树的子结构;

/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean resp = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val)
                resp = HasSubtreebyRoot(root1, root2);
            if(!resp)
                resp = HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
        }
        return resp;
    }

    public boolean HasSubtreebyRoot(TreeNode root1,TreeNode root2){
        if(root2==null)
            return true;

        if(root1==null)
            return false;

        if(root1.val!=root2.val)
            return false;

        return HasSubtreebyRoot(root1.left, root2.left)
                && HasSubtreebyRoot(root1.right, root2.right);
    }
}
