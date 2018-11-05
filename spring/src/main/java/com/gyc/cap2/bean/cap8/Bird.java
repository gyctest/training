package com.gyc.cap2.bean.cap8;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/5 0005
 */
public class Bird {
    private String name;
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
