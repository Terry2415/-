package 剑指offer编程题_第二版.test26_二叉搜索树与双向链表;

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
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
    private TreeNode pre = null;   //线索化时记录前一个节点

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;

        TreeNode resp = pRootOfTree;
        ConvertHelper(pRootOfTree);

        while(resp.left != null)
            resp=resp.left;

        return resp;
    }

    public void ConvertHelper(TreeNode node){
        if(node == null)
            return;

        ConvertHelper(node.left);
        node.left = pre;
        if(pre!= null)
            pre.right = node;
        pre = node;

        ConvertHelper(node.right);

    }
}
