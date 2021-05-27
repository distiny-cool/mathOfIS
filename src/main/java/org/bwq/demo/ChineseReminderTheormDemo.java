package org.bwq.demo;

import org.bwq.xxaqsxjc.sxjc1.ChineseRemainderTheorem;

import java.math.BigInteger;
import java.util.Scanner;

import static org.bwq.xxaqsxjc.sxjc1.ChineseRemainderTheorem.CRTfor2;

/**
 * 测试中国剩余定理，很简陋{@link ChineseRemainderTheorem}
 *
 * @author Distiny
 * @date 2021/5/27 10:50
 */
public class ChineseReminderTheormDemo {
    public static void main(String[] args) {
        BigInteger b1, b2,m1,m2;
        Scanner scan = new Scanner(System.in);

        System.out.println("请输入正整数b1：");
        if (scan.hasNextBigInteger()) {
            b1 = scan.nextBigInteger();
        } else {
            System.out.println("发生错误！");
            scan.close();
            return;
        }

        System.out.println("请输入正整数b2：");
        if (scan.hasNextBigInteger()) {
            b2 = scan.nextBigInteger();
        } else {
            System.out.println("发生错误！");
            scan.close();
            return;
        }

        System.out.println("请输入正整数m1：");
        if (scan.hasNextBigInteger()) {
            m1 = scan.nextBigInteger();
        } else {
            System.out.println("发生错误！");
            scan.close();
            return;
        }

        System.out.println("请输入正整数m2：");
        if (scan.hasNextBigInteger()) {
            m2 = scan.nextBigInteger();
        } else {
            System.out.println("发生错误！");
            scan.close();
            return;
        }
        scan.close();

        BigInteger x = CRTfor2(b1,b2,m1,m2);

        System.out.println("结果为：" + x);

    }
}
