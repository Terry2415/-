package 剑指offer编程题_第二版.test24_二叉树中和为某一值的路径;
import java.util.ArrayList;
import java.util.*;


/*
输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)
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
    private ArrayList<ArrayList<Integer>> resp = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return resp;
        FindPathwithoutSort(root, target);
        Collections.sort(resp, new Comparator<ArrayList<Integer>>(){
            public int compare(ArrayList<Integer> l1,ArrayList<Integer> l2){
                return l2.size() - l1.size();
            }
        });
        return resp;
    }
    public void FindPathwithoutSort(TreeNode root,int target){
        if(root == null)
            return;
        list.add(root.val);
        target = target - root.val;
        if( target == 0 && root.left == null && root.right == null)
            resp.add(new ArrayList<Integer>(list));
        FindPathwithoutSort(root.left, target);
        FindPathwithoutSort(root.right, target);
        list.remove(list.size()-1);
    }
}
