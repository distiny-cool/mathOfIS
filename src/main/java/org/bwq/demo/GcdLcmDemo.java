package org.bwq.demo;

import org.bwq.xxaqsxjc.sxjc1.CommonDivisorMultiple;
import org.bwq.xxaqsxjc.sxjc1.sxjc1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 使用示例：计算两个数的最大公约数和最小公倍数 {@link CommonDivisorMultiple}
 *
 * @author Distiny
 * @date 2021/5/26 15:36
 */
public class GcdLcmDemo {
    public static void main(String[] args) {
        BigInteger x, y;
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入第一个正整数：");
        if (scan.hasNextBigInteger()) {
            x = scan.nextBigInteger();
        } else {
            System.out.println("发生错误！");
            scan.close();
            return;
        }

        System.out.println("请输入第二个正整数：");
        if (scan.hasNextBigInteger()) {
            y = scan.nextBigInteger();
        } else {
            System.out.println("发生错误！");
            scan.close();
            return;
        }

        scan.close();
        System.out.println("最大公因数为：" + sxjc1.greatestCommonDivisor(x, y));
        System.out.println("最小公倍数为：" + sxjc1.leastCommonMultiple(x, y));
    }

}
