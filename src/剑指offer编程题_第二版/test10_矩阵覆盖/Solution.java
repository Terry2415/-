package 剑指offer编程题_第二版.test10_矩阵覆盖;

/*
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

public class Solution {
    public int RectCover(int target) {
        if(target==0)
            return 0;
        else if(target <= 2)
            return target;
        else
            return RectCover(target-1)+ RectCover(target-2);
    }
}
