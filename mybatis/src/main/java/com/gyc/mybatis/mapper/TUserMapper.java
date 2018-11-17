package com.gyc.mybatis.mapper;

import com.gyc.mybatis.entity.TUser;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/17
 */
public interface TUserMapper {

    TUser selectByPrimaryKey(Integer id);
}
