package 剑指offer编程题_第二版.test27_字符串的排列;
import java.util.ArrayList;
import java.util.Collections;


/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
    输入描述:
        输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */


public class Solution {
    private ArrayList<String> resp= new ArrayList<String>();

    public ArrayList<String> Permutation(String str) {
        if(str == null || str.length() == 0)
            return resp;
        PermutationHP(str.toCharArray(),0);
        Collections.sort(resp);
        return resp;
    }

    public void PermutationHP(char[] cs, int i) {
        if(i == cs.length-1){
            String val = String.valueOf(cs);
            if(!resp.contains(val))
                resp.add(val);
        }
        else{
            for(int j=i; j<cs.length; j++){
                swap(cs, i ,j);
                PermutationHP(cs,i+1);
                swap(cs, i ,j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }
}
