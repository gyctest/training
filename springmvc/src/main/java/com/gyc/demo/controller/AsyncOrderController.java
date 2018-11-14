package com.gyc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/14 0014
 */
@Controller
public class AsyncOrderController {

    @ResponseBody
    @RequestMapping("async01")
    public Callable<String> order01() {
        System.out.println(Thread.currentThread().getName() + "]主线程===> begin..." + System.currentTimeMillis());

        Callable<String> res = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + "]sub线程===> begin..." + System.currentTimeMillis());

                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName() + "]sub线程===> end  ..." + System.currentTimeMillis());

                return "order01Success...";
            }
        };

        System.out.println(Thread.currentThread().getName() + "]主线程===> end  ..." + System.currentTimeMillis());
        return res;
    }

    @ResponseBody
    @RequestMapping("async02")
    public DeferredResult<String> order02() {
        System.out.println(Thread.currentThread().getName() + "]主线程===> begin..." + System.currentTimeMillis());
        DeferredResult<String> deferredResult = new DeferredResult<>();

        new Thread(new DoTask(deferredResult)).start();

        System.out.println(Thread.currentThread().getName() + "]主线程===> end  ..." + System.currentTimeMillis());

        return deferredResult;
    }
}

class DoTask implements Runnable {
    DeferredResult<String> deferredResult;

    public DoTask(DeferredResult<String> deferredResult) {
        this.deferredResult = deferredResult;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "]sub线程===> begin..." + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "]sub线程===> end  ..." + System.currentTimeMillis());

        deferredResult.setResult("async02 执行成功...");
    }
}