package 剑指offer编程题_第二版.test29_最小的K个数;
import java.util.*;

/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */


public class Solution {
    private ArrayList<Integer> resp = new ArrayList<Integer>();
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || input.length <=0 || input.length<k || k==0)
            return resp;
        int[] kheap = Arrays.copyOfRange(input,0,k);

        for(int i=k/2-1; i>=0; i--)
            MaxHeapify(kheap,i);

        for(int i = k;i<input.length;i++){
            if(input[i] < kheap[0])
                kheap[0]=input[i];
            MaxHeapify(kheap,0);
        }

        for(int i=0; i<k; i++){
            resp.add(kheap[i]);
        }
        return resp;
    }

    public void MaxHeapify(int[] array, int i){
        if(array == null || array.length <= 1)
            return;
        int left = 2*i +1;
        int right = 2*i+2;
        int largest = i;
        int len = array.length;

        if(left < len && array[i] < array[left])
            largest = left;
        if(right < len && array[largest] < array[right])
            largest = right;

        if(largest != i){
            int temp;
            temp = array[i];
            array[i] = array[largest];
            array[largest]= temp;
            MaxHeapify(array, largest);
        }
    }
}
