/*\

在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

*/


package 剑指offer编程题_第二版.test1_二维数组中的查找;

public class Solution {
    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int i = rows-1;
        int j = 0;
        while(i>=0 && j<cols){
            if (array[i][j]< target)
                j++;
            else if(array[i][j]> target)
                i--;
            else
                return true;
        }
        return false;
    }
}
