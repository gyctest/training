package com.traning1ch4.test;

import java.util.HashMap;
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
    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put("a",1);

        ConcurrentHashMap concurrentHashMap=new ConcurrentHashMap();
        concurrentHashMap.put("1",1);
        concurrentHashMap.putIfAbsent("1",2);
        System.out.println(concurrentHashMap.get("1"));
    }
}
