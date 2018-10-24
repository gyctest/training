package com.traning1ch5.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/24 0024
 */
public class Test {

    public static void main(String[] args) {
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        System.out.println(hashMap.put("a", 1));
        System.out.println(hashMap.put("a", 2));
        System.out.println(hashMap.put("a", 3));



        System.out.println("-4的二进制字符:" + Integer.toBinaryString(-4));
        System.out.println("4的二进制字符串:" + Integer.toBinaryString(4));
        System.out.println("6的二进制字符串:" + Integer.toBinaryString(6));
        System.out.println("           4&6:" + Integer.toBinaryString(4&6));
        System.out.println("           4|6:" + Integer.toBinaryString(4|6));
        System.out.println("           4^6:" + Integer.toBinaryString(4^6));
        System.out.println("           ~4:" + Integer.toBinaryString(~4));
        System.out.println("          ~-4:" + Integer.toBinaryString(~-4));
    }
}
