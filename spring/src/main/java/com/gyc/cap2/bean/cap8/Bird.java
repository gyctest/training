package com.gyc.cap2.bean.cap8;

import org.springframework.beans.factory.annotation.Value;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class Bird {
    @Value("${bird.name}")
    private String name;
    @Value("#{2+18}")
    private Integer age;

    public Bird() {
    }

    public Bird(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
