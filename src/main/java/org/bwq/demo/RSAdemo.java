package org.bwq.demo;

import org.bwq.xxaqsxjc.sxjc1.RSA;

import java.util.Scanner;

/**
 * @author Distiny
 * @date 2021/5/27 13:44
 */
public class RSAdemo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        String str = new String() ;
        // nextLine方式接收字符串
        System.out.println("请输入你要加密的一段内容（按回车键结束）：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            str = scan.nextLine();
            System.out.println("输入的数据为：" + str);
        }
        scan.close();

        RSA a = new RSA(str);
        a.RSAEncrypt();
        a.RSADecrypt();
        a.show();
    }


}
