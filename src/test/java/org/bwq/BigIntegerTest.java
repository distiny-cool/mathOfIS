package org.bwq;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Distiny
 * @date 2021/5/26 23:15
 */
class BigIntegerTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a, b;
        while(sc.hasNext()) {
            a = sc.nextBigInteger();
            b = sc.nextBigInteger();
            System.out.println(a.add(b));   //大整数加法
            System.out.println(a.subtract(b));  //减法
            System.out.println(a.multiply(b));  //乘法
            System.out.println(a.divide(b));    //除法
            System.out.println(a.remainder(b)); //取模
            System.out.println(a.mod(b)); //取模
            System.out.println(a.modPow(b,BigInteger.valueOf(67))); //摸幂

            //大整数的比较
            if(a.compareTo(b) == 0)
                System.out.println("a == b");
            else if(a.compareTo(b) > 0)
                System.out.println("a > b");
            else if(a.compareTo(b) < 0)
                System.out.println("a < b");

            //大整数的绝对值
            System.out.println(a.abs());

            //计算大整数的幂次方
            int exp = 10;
            System.out.println(a.pow(exp));

            //返回大整数十进制的字符串表示
            System.out.println(a.toString());

            //返回大整数p进制的字符串表示
            int p = 8;
            System.out.println(a.toString(p));
        }
        sc.close();
    }
}

