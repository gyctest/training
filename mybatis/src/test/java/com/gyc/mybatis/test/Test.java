package com.gyc.mybatis.test;

import com.gyc.mybatis.entity.TUser;
import com.gyc.mybatis.mapper.TUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.InputStream;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/17
 */
public class Test {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void query() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);

        TUser tUser = mapper.selectByPrimaryKey(1);

        System.out.println(tUser);

    }

    @After
    public void after() {

        if (sqlSessionFactory != null) {
        }
    }
}
