package com.feidian.xiang.webfinal.dao.mapper;

import com.feidian.xiang.webfinal.dao.entity.Assignment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 项健健
 * @description
 * @date 创建于 18-5-27 上午12:03
 */

@Mapper
public interface AssignmentMapper {

    /**
     * list all
     *
     * @return list
     */
    List<Assignment> listAll();


    /**
     * select one
     *
     * @param id id
     * @return assignment
     */
    Assignment getById(@Param("id") Long id);

    /**
     * select one
     *
     * @param name name
     * @return name
     */
    Assignment getByName(@Param("name") String name);

    /**
     * exitsts
     *
     * @param id id
     * @return boolean
     */
    boolean exists(@Param("id") Long id);

    /**
     * delete
     *
     * @param name name
     */
    @Delete("delete from assignment where name = #{name}")
    void deleteByName(String name);

    /**
     * insert
     * @param assignment assignment
     */
    void insert(Assignment assignment);

}
