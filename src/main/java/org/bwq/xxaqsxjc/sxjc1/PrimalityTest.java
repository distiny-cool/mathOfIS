package org.bwq.xxaqsxjc.sxjc1;

import java.math.BigInteger;
import java.util.Random;

import static java.lang.Long.MAX_VALUE;

/**
 * 素数测试，先写几个简单的吧
 *
 * @author Distiny
 * @date 2021/5/27 14:46
 */
public class PrimalityTest {
    public static void main(String[] args) {
        BigInteger n = new BigInteger("2074722246773485207821695222107608587480996474721117292752992589912196684750549658310084416732550077");
        if (fermat(n,30))
            System.out.println(n + "是素数");
        else System.out.println(n + "不是素数");
    }

    /**
     * 埃拉斯托特尼筛法：
     * 测试从2到根号N的数能不能被N整除的确定性素数测试
     * 建议N小于999999999999999999时使用
     *
     * @param n
     * @author: distiny
     * @date: 2021/5/27
     * @return: boolean
     */
    public static boolean violentIfPrime(BigInteger n) {

        //A constant holding the maximum value a long can have, 2^63-1.
        if (n.compareTo(new BigInteger(String.valueOf(MAX_VALUE))) >= 0)
            System.out.println("正在使用埃拉斯托特尼筛法进行素数测试，待测数值超过0x7fffffffffffffffL,本方法可能会出现不可知错误");


        if (n.compareTo(sxjc1.VALUE_1) == 0) {
            return false;
        } else if (n.compareTo(sxjc1.VALUE_2) == 0 || (n.compareTo(new BigInteger("3")) == 0)) {
            return true;
        } else {
            long n0 = n.longValue();
            long p = (long) Math.sqrt(n0);

            for (long i = 2; i <= p; i++) {
                if (n0 % i == 0) {
                    System.out.println(n + "可以被" + i + "整除");
                    return false;
                }
            }

            return true;
        }
    }


    /**
     * 费马素数测试
     *
     * @param n
     * @param t
     * @author: distiny
     * @date: 2021/5/27
     * @return: boolean
     */
    public static boolean fermat(BigInteger n, int t){
        if (t < 1) {
            System.out.println("安全参数t应是正整数");
        }


        if ((n == null) || (n.compareTo(sxjc1.VALUE_1) <= 0)) {
            return false;
        }

        if (n.compareTo(sxjc1.VALUE_2)==0 || (n.compareTo(new BigInteger("3")) == 0)) {
            return true;
        } else {
            if ((n.mod(sxjc1.VALUE_2)).compareTo(sxjc1.VALUE_0) == 0) {
                return false;
            }
        }

        BigInteger b;

        for (int i = 0; i < t; i++) {
            do {
                b = new BigInteger(n.bitLength(), new Random());
                b = b.mod(n);
            } while ((b.compareTo(sxjc1.VALUE_2) < 0) || (b.compareTo(n.subtract(sxjc1.VALUE_2)) > 0));

            if (sxjc1.greatestCommonDivisor(b, n).compareTo(sxjc1.VALUE_1) > 0) {
                return false;
            } else {
                if ((b.modPow(n.subtract(sxjc1.VALUE_1),n)).compareTo(sxjc1.VALUE_1)==0) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
///**
// * BigInteger中自带的MillerRabin算法
// *
// * @param iterations
// * @param rnd
// * @return: boolean
// */
//private boolean passesMillerRabin(int iterations, Random rnd) {
//        // Find a and m such that m is odd and this == 1 + 2**a * m
//        BigInteger thisMinusOne = this.subtract(ONE);
//        BigInteger m = thisMinusOne;
//        int a = m.getLowestSetBit();
//        m = m.shiftRight(a);
//
//        // Do the tests
//        if (rnd == null) {
//            rnd = ThreadLocalRandom.current();
//        }
//        for (int i=0; i < iterations; i++) {
//            // Generate a uniform random on (1, this)
//            BigInteger b;
//            do {
//                b = new BigInteger(this.bitLength(), rnd);
//            } while (b.compareTo(ONE) <= 0 || b.compareTo(this) >= 0);
//
//            int j = 0;
//            BigInteger z = b.modPow(m, this);
//            while (!((j == 0 && z.equals(ONE)) || z.equals(thisMinusOne))) {
//                if (j > 0 && z.equals(ONE) || ++j == a)
//                    return false;
//                z = z.modPow(TWO, this);
//            }
//        }
//        return true;
//    }

}
