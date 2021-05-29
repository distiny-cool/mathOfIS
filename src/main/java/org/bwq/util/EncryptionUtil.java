package org.bwq.util;

/**
 * 一些加密中用到的工具，如ASCII码与字符串的互相转换
 *
 * @author Distiny
 * @date 2021/5/28 8:56
 */
public class EncryptionUtil {

    public static void main(String[] args) {
        System.out.println("好好学习="+stringToAscii("好好学习"));
        System.out.println("22909,22909,23398,20064="+asciiToString("22909,22909,23398,20064"));
    }

    /**
     * 将字符串转成Ascii码，每个字符中间用，分隔
     *
     * @param value 输入的字符串
     * @author: distiny
     * @date: 2021/5/28
     * @return: java.lang.String
     */
    public static String stringToAscii(String value) {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i != chars.length - 1) {
                sbu.append((int) chars[i]).append(",");
            } else {
                sbu.append((int) chars[i]);
            }
        }
        return sbu.toString();
    }

    /**
     * 将Ascii码转成字符串，每个字符中间用，分隔
     *
     * @param value 输入的Ascii码，每个字符中间用，分隔
     * @author: distiny
     * @date: 2021/5/28
     * @return: java.lang.String
     */
    public static String asciiToString(String value) {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
    // TODO: 2021/5/28 这里的功能还没做，两个或者多个字符串转成ASCII码串需让每个字母的ASCII码值都作为3位，不够的前面补0，然后合并成大整数
//    /**
//     * 将两个字符串一组转成Ascii码，每个两个字符中间用，分隔
//     *
//     * @param value 输入的字符串
//     * @author: distiny
//     * @date: 2021/5/28
//     * @return: java.lang.String
//     */
//    public static String stringToAscii2(String value) {
//        StringBuffer sbu = new StringBuffer();
//        char[] chars = value.toCharArray();
//        for (int i = 0; i < chars.length; i+=2) {
//            if (i != chars.length - 1) {
//                sbu.append((int) chars[i]).append(",");
//            } else {
//                sbu.append((int) chars[i]);
//            }
//        }
//        return sbu.toString();
//    }
//

    // TODO: 2021/5/28 三位三位转换，应该前面的能做出来了这个也不难了
//    /**
//     * 将Ascii码（每个6位包含两个字符，中间用，分隔）转成2个字符，拼接成字符串
//     *
//     * @param value 输入的Ascii码，每个字符中间用，分隔
//     * @author: distiny
//     * @date: 2021/5/28
//     * @return: java.lang.String
//     */
//    public static String asciiToString2(String value) {
//        StringBuffer sbu = new StringBuffer();
//        String[] chars = value.split(",");
//        for (int i = 0; i < chars.length; i++) {
//            sbu.append((char) Integer.parseInt(chars[i]));
//        }
//        return sbu.toString();
//    }
}
