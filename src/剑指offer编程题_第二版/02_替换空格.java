/*

 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/


package 剑指offer编程题_第二版.test2_替换空格;

public class Solution {
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }
}
