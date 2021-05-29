package org.bwq.xxaqsxjc.sxjc1;

import java.math.BigInteger;

import static org.bwq.xxaqsxjc.sxjc1.BezoutIdentity.BezoutCalForS;
import static org.bwq.xxaqsxjc.sxjc1.CommonDivisorMultiple.greatestCommonDivisor;

/**
 * 中国剩余定理
 * 给出同余组方程如：x与b1模m1同余
 *               x与b2模m2同余
 *               其中m1,m2互素
 *               可求得x =
 * 方法为《信息安全数学基础》第二版 P100
 * @author Distiny
 * @date 2021/5/27 9:15
 */
public class ChineseRemainderTheorem {

    /**
     * 辅助计算的m和mi即Mi
     */
    private static BigInteger m = sxjc1.VALUE_0;
    private static BigInteger[] mi;
    private static BigInteger[] Mi;

    /**
     * 用于储存计算结果
     */
    private static BigInteger x = sxjc1.VALUE_0;

    /**
     * 利用中国剩余定理计算
     * 给出同余组方程如：x与b1模m1同余
     *               x与b2模m2同余
     *               其中m1,m2互素
     *               可求得x =
     *
     * @param b1
     * @param b2
     * @param m1
     * @param m2
     * @author: distiny
     * @date: 2021/5/27
     * @return: java.math.BigInteger
     */
    public static BigInteger CRTfor2(BigInteger b1, BigInteger b2, BigInteger m1, BigInteger m2){
        if(greatestCommonDivisor(m1,m2).compareTo(sxjc1.VALUE_1)!=0)
        {
            System.out.println("请保证m1和m2互素");
            return null;
        }

        m=m1.multiply(m2);

        BigInteger M1s = BezoutCalForS(m2,m1);
        BigInteger M2s = BezoutCalForS(m1,m2);

        x = (M1s.multiply(m2).multiply(b1)).add(M2s.multiply(m1).multiply(b2));
        return x;

    }

}
