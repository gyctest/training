package com.gyc.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/12 0012
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("xxxxxxxxxxxxxxxxxxxxxxx OrderServlet.doGet xxxxxxxxxxxxxxxxxxxxxxx");
        resp.getWriter().write("order servlet success..........");
    }
}
