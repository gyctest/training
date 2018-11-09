package com.gyc.cap11.service;

import com.gyc.cap11.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/8 0008
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    @Transactional
    public void insert() {
        orderDao.insert();

//        int a = 1 / 0;
    }
}
