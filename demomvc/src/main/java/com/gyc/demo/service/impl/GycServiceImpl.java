package com.gyc.demo.service.impl;

import com.gyc.demo.annotation.DemoService;
import com.gyc.demo.service.GycService;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/13
 */
@DemoService("gycService")
public class GycServiceImpl implements GycService {

    public String query(String name, String age) {
        return "query:" + name + age;
    }

    public String insert(String name) {
        return "insert:" + name;
    }

    public String update(String name) {
        return "update:" + name;
    }
}
