package 剑指offer编程题_第二版.test12_数值的整数次方;

/*
给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 */

public class Solution {
    public double Power(double base, int exponent) {
        if (exponent==0)
            return 1;
        else if (exponent<0)
            return power(1/base,-exponent);
        else
            return power(base,exponent);
    }
    public double power(double base, int exponent){
        if (exponent < 2)
            return base;
        return base*power(base, exponent-1);
    }
}
