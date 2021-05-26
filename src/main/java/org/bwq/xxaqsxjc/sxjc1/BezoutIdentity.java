package org.bwq.xxaqsxjc.sxjc1;

import java.math.BigInteger;
import java.util.LinkedList;

import static org.bwq.xxaqsxjc.sxjc1.sxjc1.greatestCommonDivisor;

/**
 * 贝祖等式，给出正整数a，b，存在s,t使得sa+tb=(a,b)
 * 本函数用于求解s和t
 * 使用的方法为《信息安全数学基础》（第二版）p29
 *
 * @author Distiny
 * @date 2021/5/26 18:50
 */
public class BezoutIdentity {

    /**
     * 存放输入的整数a和b
     */
    private static BigInteger valueOfa = sxjc1.VALUE_0;
    private static BigInteger valueOfb = sxjc1.VALUE_0;
    /**
     * 存放a和b的最大公因数
     */
    private static BigInteger valueOfc = sxjc1.VALUE_0;
    /**
     * 存放计算结果s和t
     */
    private static BigInteger[] ValueOfST = new BigInteger[2];


    /**
     * 用于直接生成该类型对象，其中保存了a,b,s,t的值
     *
     * @param a
     * @param b
     * @author: distiny
     * @date: 2021/5/26
     */
    public BezoutIdentity(BigInteger a, BigInteger b) {
        valueOfa = a;
        valueOfb = b;
        BezoutCal(a, b);
    }

    /**
     * 默认构造函数，调用函数用于初始化
     *
     * @author: distiny
     * @date: 2021/5/26
     */
    public BezoutIdentity() {
    }

    /**
     * 返回a的值
     *
     * @author: distiny
     * @date: 2021/5/26
     * @return: java.math.BigInteger
     */
    public static BigInteger getValueOfa() {
        return valueOfa;
    }

    /**
     * 返回b的值
     *
     * @author: distiny
     * @date: 2021/5/26
     * @return: java.math.BigInteger
     */
    public static BigInteger getValueOfb() {
        return valueOfb;
    }

    /**
     * 返回a,b的最大公因数
     *
     * @author: distiny
     * @date: 2021/5/26
     * @return: java.math.BigInteger
     */
    public static BigInteger getGcd() {
        return valueOfc;
    }

    /**
     * 返回s的值
     *
     * @author: distiny
     * @date: 2021/5/26
     * @return: java.math.BigInteger
     */
    public static BigInteger getValueOfs() {
        return ValueOfST[0];
    }

    /**
     * 返回t的值
     *
     * @author: distiny
     * @date: 2021/5/26
     * @return: java.math.BigInteger
     */
    public static BigInteger getValueOft() {
        return ValueOfST[1];
    }

    /**
     * 用于计算a和b的贝祖等式
     * 使用的方法为《信息安全数学基础》（第二版）p29
     * 直接使用了书中的做法
     *
     * @param a
     * @param b
     * @author: distiny
     * @date: 2021/5/26
     * @return: java.math.BigInteger[]
     */
    public BigInteger[] BezoutCal(BigInteger a, BigInteger b) {

        BigInteger c = greatestCommonDivisor(a,b);//先对a，b同除以最大公因数
        valueOfc = c;
        a = a.divide(c);
        b = b.divide(c);

        if ((a.compareTo(sxjc1.VALUE_0) <= 0) || (b.compareTo(sxjc1.VALUE_0) <= 0)) {
            System.out.println("请输入正整数！");
            return null;
        }

        /**
         * s, t, q, r : 辅助数组
         */
        LinkedList<BigInteger> s = new LinkedList<>();
        LinkedList<BigInteger> t = new LinkedList<>();
        LinkedList<BigInteger> q = new LinkedList<>();
        LinkedList<BigInteger> r = new LinkedList<>();

        //给j,s,t,q,r赋初值
        r.add(0, a);
        r.add(1, b);
        s.add(0, sxjc1.VALUE_1);
        s.add(1, sxjc1.VALUE_0);
        t.add(0, sxjc1.VALUE_0);
        t.add(1, sxjc1.VALUE_1);
        q.add(null);
        q.add(null);//只是为了填充链表，使得其可以在最后add（保持编号的一致性）
        q.add(2, r.get(0).divide(r.get(1)));
        r.add(2, ((r.get(0)).subtract((q.get(2).multiply(r.get(1))))));

        int j = 1;//辅助数组的指针

        while (r.get(j + 1).compareTo(sxjc1.VALUE_0) != 0){
                j++;
                s.add(j, ((s.get(j - 2)).subtract((q.get(j).multiply(s.get(j - 1))))));
                t.add(j, ((t.get(j - 2)).subtract((q.get(j).multiply(t.get(j - 1))))));
                q.add(j + 1, r.get(j - 1).divide(r.get(j)));
                r.add(j + 1, ((r.get(j - 1)).subtract((q.get(j + 1).multiply(r.get(j))))));
            }

        ValueOfST[0] = s.get(j);
        ValueOfST[1] = t.get(j);

        return ValueOfST;
    }


}
