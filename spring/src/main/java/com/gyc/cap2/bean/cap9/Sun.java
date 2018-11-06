package com.gyc.cap2.bean.cap9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/6 0006
 */
@Component
public class Sun {

    private Moon moon;

    @Autowired
    public Sun(Moon moon) {
        this.moon = moon;
    }

    public Moon getMoon() {
        return moon;
    }

    //    @Autowired
    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    @Override
    public String toString() {
        return "Sun{" +
                "moon=" + moon +
                '}';
    }
}
