package org.bwq.util;

import java.math.BigInteger;
import java.util.Random;

/**
 * @author Distiny
 * @date 2021/5/28 0:58
 */


public class RandomUtil {
    /**
     * 密钥位宽,默认512位
     */
    private static int KeysBitLength = 512;

    /**
     * 默认安全参数为100
     */
    private static int DEFAULT_PRIME_CERTAINTY = 100;

    /**
     * 生成指定位数和安全参数的素数
     *
     * @param length    生成素数的位数（默认为512）
     * @param certainty     生成素数的安全参数（默认为100）
     * @author: distiny
     * @date: 2021/5/28
     * @return: java.math.BigInteger
     */
    public static BigInteger getBigPrime(int length, int certainty) {
        BigInteger p = new BigInteger(length, certainty, new Random());
        return p;
    }


    /**
     * 生成默认位数（默认为512）和默认安全参数（默认为100）的素数
     *
     * @author: distiny
     * @date: 2021/5/28
     * @return: java.math.BigInteger
     */
    public static BigInteger getBigPrime() {
        BigInteger p = new BigInteger(KeysBitLength, DEFAULT_PRIME_CERTAINTY, new Random());
        return p;
    }
}
