package 剑指offer编程题_第二版.test23_二叉搜索树的后序遍历序列;
import java.util.Arrays;


/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        int ssize = sequence.length;

        if(ssize == 0)
            return false;
        if(ssize <= 2)
            return true;

        int rootval = sequence[ssize-1];
        int[] lts={};
        int[] rts={};

        int i;
        for(i=0; i<ssize-1; i++)
            if(sequence[i]>rootval)
                break;

        if(i == ssize-1){
            lts = Arrays.copyOfRange(sequence, 0, i);
            return VerifySquenceOfBST(lts);
        }
        else if(i == 0){
            for(int j=i+1;j<ssize-1;j++){
                if(sequence[j]< rootval)
                    return false;
            }
            rts = Arrays.copyOfRange(sequence,i,ssize-1);
            return VerifySquenceOfBST(rts);
        }
        else{
            for(int j=i+1;j<ssize-1;j++){
                if(sequence[j]< rootval)
                    return false;
            }
            lts = Arrays.copyOfRange(sequence, 0, i);
            rts = Arrays.copyOfRange(sequence,i,ssize-1);
            return VerifySquenceOfBST(lts) && VerifySquenceOfBST(rts);
        }
    }
}
