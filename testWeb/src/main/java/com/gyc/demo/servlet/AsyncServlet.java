package com.gyc.demo.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
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
 * @date 2018/11/14 0014
 */
@WebServlet(value = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(Thread.currentThread().getName() + "]主线程 begin..." + System.currentTimeMillis());

        final AsyncContext startAsync = req.startAsync();

        startAsync.start(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "]子线程 begin..." + System.currentTimeMillis());
                try {
                    Thread.sleep(3000);

                    AsyncContext asyncContext = req.getAsyncContext();
                    ServletResponse response = asyncContext.getResponse();
                    response.getWriter().write(" async success....");
                    System.out.println(Thread.currentThread().getName() + "]子线程 end  ..." + System.currentTimeMillis());

                    startAsync.complete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(Thread.currentThread().getName() + "]主线程 end  ..." + System.currentTimeMillis());
    }
}
