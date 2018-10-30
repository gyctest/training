package com.traning1ch5.test.bitwise;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/10/30 0030
 */
public class BitTest {
    public static void main(String[] args){
        int a=4;
        int b=6;
        System.out.println("6    bitnum:"+Integer.toBinaryString(6));
        System.out.println("4    bitnum:"+Integer.toBinaryString(4));
        System.out.println("4&6  bitnum:"+Integer.toBinaryString(4&6));
        System.out.println("4|6  bitnum:"+Integer.toBinaryString(4|6));
        System.out.println("4^6  bitnum:"+Integer.toBinaryString(4^6));
        System.out.println("~4   bitnum:"+Integer.toBinaryString(~4));
    }
}
