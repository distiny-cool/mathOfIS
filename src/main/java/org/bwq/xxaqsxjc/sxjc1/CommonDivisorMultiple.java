package org.bwq.xxaqsxjc.sxjc1;

import java.math.BigInteger;

/**
 * 用于计算最大公因数和最小公倍数
 *
 * @author Distiny
 * @date 2021/5/26 14:11
 */
public class CommonDivisorMultiple {

    /**
     * 存放计算结果
     */
    private static BigInteger result = sxjc1.VALUE_0;
//    实际上BigInteger中也提供了常用的部分整数，可用下面的语句代替
//    private static BigInteger result = BigInteger.ZERO;

    /**
     * 求a和b的最大公因数
     *
     * @param a 入参大整数a
     * @param b 入参大整数b
     * @author: distiny
     * @date: 2021/5/26
     * @return: java.math.BigInteger
     */
    public static BigInteger greatestCommonDivisor(BigInteger a, BigInteger b) {
        if (a.compareTo(b) == -1) {
            BigInteger tmp = b;
            b = a;
            a = tmp;
        }

        BigInteger c = a.mod(b);

        if (c.compareTo(BigInteger.ZERO) == 0)
            result = b;
        else {
            result = greatestCommonDivisor(b, c);
        }

        return result;
    }

    /**
     * 两个数的最大公倍数
     *
     * @param a 入参大整数a
     * @param b 入参大整数b
     * @author: distiny
     * @date: 2021/5/26
     * @return: java.math.BigInteger
     */
    public static BigInteger leastCommonMultiple(BigInteger a, BigInteger b) {
        return (a.multiply(b)).divide((greatestCommonDivisor(a,b)));
    }
}
