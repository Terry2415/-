package 剑指offer编程题_第二版.test4_重建二叉树;
import java.util.*;

/*
 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */


//Definition for binary tree
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if ( pre.length == 0 || in.length == 0 )
            return null;
        TreeNode root = new TreeNode(pre[0]);

        int i = arrayindexOf(in, pre[0]);

        int[] preleft = Arrays.copyOfRange(pre,1,i+1);
        int[] preright = Arrays.copyOfRange(pre,1+i,pre.length);
        int[] inleft = Arrays.copyOfRange(in,0,i);
        int[] inright = Arrays.copyOfRange(in,i+1,in.length);

        root.left = reConstructBinaryTree(preleft, inleft);
        root.right = reConstructBinaryTree(preright, inright);
        return root;
    }

    public int arrayindexOf(int []array, int target){
        int i=0;
        for (;i<array.length;i++)
            if (array[i] == target)
                return i;
        return -1;
    }
}
