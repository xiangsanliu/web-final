package com.feidian.xiang.webfinal.dao.mapper;

import com.feidian.xiang.webfinal.dao.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author 项健健
 * @description
 * @date 创建于 18-5-27 上午12:03
 */
public interface UserMapper {

    /**
     * exists
     *
     * @param id id
     * @return boolean
     */
    boolean exists(@Param("id") String id);

    /**
     * select one
     * @param id id
     * @return user
     */
    User getById(@Param("id") String id);

}
