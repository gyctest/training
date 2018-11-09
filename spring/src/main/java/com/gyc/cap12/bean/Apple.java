package com.gyc.cap12.bean;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/9 0009
 */
public class Apple {
    private String color;
    private double kg;

    public Apple() {
        System.out.println("apple construct.....");
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getKg() {
        return kg;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }
}
