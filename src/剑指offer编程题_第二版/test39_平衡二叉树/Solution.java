package 剑指offer编程题_第二版.test39_平衡二叉树;

/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root ==null)
            return true;

        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right)&&
                Math.abs(maxDepth(root.left)-maxDepth(root.right)) <=1;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
