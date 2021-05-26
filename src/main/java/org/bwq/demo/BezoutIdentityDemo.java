package org.bwq.demo;

import org.bwq.xxaqsxjc.sxjc1.BezoutIdentity;
import org.bwq.xxaqsxjc.sxjc1.sxjc1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Distiny
 * @date 2021/5/26 20:06
 */
public class BezoutIdentityDemo {
    public static void main(String[] args) {
        BigInteger a, b;
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入第一个正整数a：");
        if (scan.hasNextBigInteger()) {
            a = scan.nextBigInteger();
        } else {
            System.out.println("发生错误！");
            scan.close();
            return;
        }

        System.out.println("请输入第二个正整数b：");
        if (scan.hasNextBigInteger()) {
            b = scan.nextBigInteger();
        } else {
            System.out.println("发生错误！");
            scan.close();
            return;
        }
        scan.close();

        BezoutIdentity result = new BezoutIdentity(a, b);


        System.out.println("最大公因数为：" + result.getGcd());
        System.out.println("s:" + result.getValueOfs());
        System.out.println("t:" + result.getValueOft());

        System.out.println("贝祖等式:(" +
                result.getValueOfs() +
                "*" +
                a +
                ")+(" +
                result.getValueOft() +
                "*" +
                b +
                ")=" +
                result.getGcd());
    }

}
