package org.bwq.xxaqsxjc.sxjc1;

import java.math.BigInteger;

/**
 * 存一些常用的数值和写好了的函数，便于直接调用
 *
 * @author Distiny
 * @date 2021/5/26 14:13
 */
public class sxjc1 {
    /**
     * 大整数常量-1
     */
    public static final BigInteger VALUE_MINUS_1 = BigInteger.valueOf(-1);

    /**
     * 大整数常量0
     */
    public static final BigInteger VALUE_0 = BigInteger.valueOf(0);

    /**
     * 大整数常量1
     */
    public static final BigInteger VALUE_1 = BigInteger.valueOf(1);

    /**
     * 大整数常量2
     */
    public static final BigInteger VALUE_2 = BigInteger.valueOf(2);

    /**
     * 大整数常量4
     */
    public static final BigInteger VALUE_4 = BigInteger.valueOf(4);

    /**
     * 大整数常量8
     */
    public static final BigInteger VALUE_8 = BigInteger.valueOf(8);

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
        return CommonDivisorMultiple.greatestCommonDivisor(a, b);
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
        return CommonDivisorMultiple.leastCommonMultiple(a, b);
    }

    /**
     * 返回计算贝祖等式后又s变为正之后的值
     *
     * @author: distiny
     * @date: 2021/5/27
     * @return: java.math.BigInteger
     */
    public static BigInteger BezoutCalForS(BigInteger a, BigInteger b) {
        return BezoutIdentity.BezoutCalForS(a, b);
    }

}
