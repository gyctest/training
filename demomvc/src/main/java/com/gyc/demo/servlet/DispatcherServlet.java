package com.gyc.demo.servlet;

import com.gyc.demo.annotation.DemoController;
import com.gyc.demo.annotation.DemoRequestMapping;
import com.gyc.demo.annotation.DemoService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/13
 */
public class DispatcherServlet extends HttpServlet {

    private List<String> classNames = new ArrayList<>();
    private Map<String, Object> beans = new ConcurrentHashMap<>();

    public DispatcherServlet() {
        //1.扫描那些包
        doScanPackage("com.gyc.demo");
        //2.实例化类
        doInstance();
        //3.IOC di
        doDi();
    }

    private void doDi() {
        if(beans.isEmpty()){
            return;
        }
        //把service注入到controller
        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object instance = entry.getValue();
            //获取类，声明的注解
            Class<?> clazz = instance.getClass();

        }
    }

    private void doInstance() {
        if (classNames.isEmpty()) {
            return;
        }
        for (String className : classNames) {
            // com/gyc/demo/xxxService.class
            String cn = className.replaceAll(".class", "");
            try {
                Class<?> clazz = Class.forName(cn);
                if (clazz.isAnnotationPresent(DemoController.class)) {
                    DemoController controller = clazz.getAnnotation(DemoController.class);
                    Object instance = clazz.newInstance();

                    DemoRequestMapping requestMapping = clazz.getAnnotation(DemoRequestMapping.class);
                    String beanName = requestMapping.value();

                    beans.put(beanName, instance);
                }else if (clazz.isAnnotationPresent(DemoService.class)) {
                    DemoService controller = clazz.getAnnotation(DemoService.class);
                    Object instance = clazz.newInstance();

                    String beanName = controller.value();

                    beans.put(beanName, instance);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void doScanPackage(String basePackage) {
        //扫描编译好的class路径类
        URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));

        String fileStr = url.getFile();
        String[] files = new File(fileStr).list();
        for (String path : files) {
            File filePath = new File(fileStr + path);
            if (filePath.isDirectory()) {
                doScanPackage(basePackage + "." + path);
            } else {
                classNames.add(basePackage + "." + filePath.getName());
            }
        }
    }

}
