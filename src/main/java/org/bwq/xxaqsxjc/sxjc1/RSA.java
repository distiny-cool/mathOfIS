package org.bwq.xxaqsxjc.sxjc1;

import java.math.BigInteger;

import static org.bwq.util.EncryptionUtil.stringToAscii;
import static org.bwq.util.RandomUtil.getBigPrime;

/**
 * RSA加解密算法
 * 使用了中国剩余定理来优化算法
 *
 * @author Distiny
 * @date 2021/5/27 17:59
 */
public class RSA {

    /**
     * 私钥{p, q, d, dP, dQ, qinv}
     */
    private static BigInteger p, q, d, dP, dQ, qinv;

    /**
     * 公钥 {e,n}
     */
    private static BigInteger n, e;

    /**
     * n的欧拉函数值
     */
    private static BigInteger EulerN;

    /**
     * 存储明文
     */
    private String PlainText;

    /**
     * 存储密文
     */
    private static String CipherText;

    /**
     * 存储明文(每一个字符存在一个单元里面）
     */
    private static String[] PlainTextList;

    /**
     * 存储密文(每一个大整数作为字符存在一个单元里面）
     */
    private static String[] CipherTextList;

    /**
     * 给密文取模的默认值为95
     */
    private static int DEFAULT_MOD_VALUE = 95;

    // TODO: 2021/5/28 这里还没有做加密一长串字符串的，只能单个字符加密解密 原因是一长串不应该一个一个加密，然后把密文存起来，这样的操作在实际中是不可能的！（就是实际上如果得到了密文和密钥，因为密文其实被mod了，是残缺的，用本方法是得不到明文的）
    // todo： 应该把n个字符一起加密，然后可以可以仅仅根据密文的值和密钥就可以得到明文，但是由于密文的位数不确定，这个操作一时还没有想出好办法，而且查资料也暂时没找到，假期有时间再做！

    /**
     * 构造函数，生成RSA的对象,并进行加解密得到密文
     *
     * @param plainText 输入需要加密的明文，暂时不能加密中文
     * @author: distiny
     * @date: 2021/5/28
     * @return:
     */
    public RSA(String plainText) {
        p = getBigPrime();
        //System.out.println("生成随机密钥p="+p);
        do q = getBigPrime();
        while (q.compareTo(p) == 0);
        //System.out.println("生成随机密钥q="+q);
        n = p.multiply(q);
        //System.out.println("生成公钥n="+n);
        EulerN = (p.subtract(sxjc1.VALUE_1).multiply(q.subtract(sxjc1.VALUE_1)));
        //System.out.println("公钥n的欧拉函数值="+EulerN);

        do e = getBigPrime(8, 100);//默认确定度100
        while (sxjc1.greatestCommonDivisor(e, EulerN).compareTo(sxjc1.VALUE_1) != 0);

        //System.out.println("生成公钥e="+e);

        d = sxjc1.BezoutCalForS(e, EulerN);
        //System.out.println("生成私钥d="+d);

        dP = d.mod(p.subtract(sxjc1.VALUE_1));
        dQ = d.mod(q.subtract(sxjc1.VALUE_1));
        qinv = q.modInverse(p);

        PlainText = stringToAscii(plainText);
        //System.out.println("明文"+PlainText);

        PlainTextList = PlainText.split(",");

    }

    /**
     * 对于对象中的明文进行加密（目前使用时并不应该通过外部对象直接调用,但是暂时先这样吧）
     *
     * @author: distiny
     * @date: 2021/5/29
     * @return: java.lang.String
     */
    public String RSAEncrypt() {
        CipherTextList = new String[PlainTextList.length];

        BigInteger x;
        for (int i = 0; i < PlainTextList.length; i++) {
            x = RSAEncrypt(PlainTextList[i]);
            CipherTextList[i] = x.toString();
        }

        StringBuffer sbu = new StringBuffer();
        for (int i = 0; i < PlainTextList.length; i++) {
            x = new BigInteger(CipherTextList[i]).mod(BigInteger.valueOf(DEFAULT_MOD_VALUE)).add(BigInteger.valueOf(32));
            sbu.append((char) Integer.parseInt(x.toString()));
        }
        CipherText = sbu.toString();
        System.out.println("密文：" + CipherText);
        return CipherText;
    }

    /**
     * 对于对象中的密文进行解密（目前使用时并不应该通过外部对象直接调用,但是暂时先这样吧）
     *
     * @author: distiny
     * @date: 2021/5/29
     * @return: java.lang.String
     */
    public String RSADecrypt() {
        BigInteger x;
        for (int i = 0; i < CipherTextList.length; i++) {
            x = RSADecryptByCRT(CipherTextList[i]);
            PlainTextList[i] = x.toString();
        }
        String plantext2 = "";
        for (int i = 0; i < PlainTextList.length; i++)
            plantext2 = plantext2 + (char) Integer.parseInt(PlainTextList[i]);
        System.out.println("解密后的明文为：" + plantext2);
        return plantext2;
    }


    /**
     * 用RSA加密单个数字
     *
     * @param PlainM
     * @author: distiny
     * @date: 2021/5/29
     * @return: java.math.BigInteger
     */
    public static BigInteger RSAEncrypt(String PlainM) {

        BigInteger m = new BigInteger(PlainM);

        //System.out.println("明文m=" + m);


        BigInteger c = m.modPow(e, n);

        //System.out.println("密文c=" + c);
        return c;
    }

    /**
     * RSA解密单个大数字
     *
     * @param PlainC
     * @author: distiny
     * @date: 2021/5/29
     * @return: java.math.BigInteger
     */
    public static BigInteger RSADecrypt(String PlainC) {
        BigInteger c = new BigInteger(String.valueOf(PlainC));
        //System.out.println("密文c=" + c);

        BigInteger m = c.modPow(d, n);
        //System.out.println("明文m=" + m);
        return m;

    }

    /**
     * 使用中国剩余定理优化RSA解密单个数字
     *
     * @param PlainC
     * @author: distiny
     * @date: 2021/5/29
     * @return: java.math.BigInteger
     */
    public static BigInteger RSADecryptByCRT(String PlainC) {
        BigInteger c = new BigInteger(String.valueOf(PlainC));
        //System.out.println("密文c=" + c);

        BigInteger m1 = c.modPow(dP, p);
        BigInteger m2 = c.modPow(dQ, q);
        BigInteger h = qinv.multiply(m1.subtract(m2)).mod(p);
        BigInteger m = m2.add(h.multiply(q).mod(p.multiply(q)));


        //System.out.println("明文m=" + m);
        return m;

    }

    public void show() {
        System.out.println("生成的私钥p：" + p);
        System.out.println("        q：" + q);
        System.out.println("        d：" + d);
        System.out.println("        dQ：" + dQ);
        System.out.println("        dP：" + dP);
        System.out.println("        qinv：" + qinv);

        System.out.println("生成的公钥e：" + e);
        System.out.println("        n：" + n);
    }


}
