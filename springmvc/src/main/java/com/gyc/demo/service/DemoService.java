package com.gyc.demo.service;

import com.gyc.demo.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/13 0013
 */
@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    public void buyService() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXX DemoService XXXXXXXXXXXXXXXXXXXXXXXXX");
        demoDao.insert();
    }
}
