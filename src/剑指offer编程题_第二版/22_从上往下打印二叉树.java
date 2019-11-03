package 剑指offer编程题_第二版.test22_从上往下打印二叉树;
import java.util.ArrayList;


/*
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> queue = new ArrayList<>();
        if(root == null){
            return list;
        }
        queue.add(root);
        while(queue.size()!=0)
        {
            TreeNode temp;
            temp = queue.remove(0);
            list.add(temp.val);
            if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
        }
        return list;
    }
}
