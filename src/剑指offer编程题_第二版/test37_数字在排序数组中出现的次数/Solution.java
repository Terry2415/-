package 剑指offer编程题_第二版.test37_数字在排序数组中出现的次数;

/*
统计一个数字在排序数组中出现的次数。
 */


public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array ==null || array.length==0)
            return 0;
        int index = BinarySearch(array,k);
        if(index == -1)
            return 0;

        int count=1;
        for(int i=index+1;i<array.length && array[i]==k;i++){
            count++;
        }
        for(int i=index-1;i>=0 && array[i]==k;i--){
            count++;
        }
        return count;
    }

    public int BinarySearch(int[] array , int k) {
        int min = 0;
        int max = array.length-1;
        int mid = (min+max)/2;

        while(array[mid]!= k){
            if(k > mid)
                min =mid+1;
            else
                max = mid-1;
            mid = (min+max)/2;

            if(min>max){
                return -1;
            }
        }
        return mid;
    }
}
