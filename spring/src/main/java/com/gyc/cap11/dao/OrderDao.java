package com.gyc.cap11.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/8 0008
 */
@Repository
public class OrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert() {
        String sql = "INSERT INTO `order`(ordertime,ordermoney,orderstatus) VALUES ( ?,?,?)";
        jdbcTemplate.update(sql,  new Date(), 30,0);
        System.out.println("插入数据完成..........");
    }

}
