package com.gyc.demo.controller;

import com.gyc.demo.annotation.DemoController;
import com.gyc.demo.annotation.DemoQualifier;
import com.gyc.demo.annotation.DemoRequestMapping;
import com.gyc.demo.annotation.DemoRequestParam;
import com.gyc.demo.service.GycService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/13
 */
@DemoController
@DemoRequestMapping("/gyc")
public class GycController {


    @DemoQualifier("gycService")
    private GycService gycService;

    @DemoRequestMapping("/query")
    public void demoTest(HttpServletRequest request, HttpServletResponse response,
                         @DemoRequestParam("name") String name,
                         @DemoRequestParam("age") String age) {

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            String result = gycService.query(name, age);
            writer.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
