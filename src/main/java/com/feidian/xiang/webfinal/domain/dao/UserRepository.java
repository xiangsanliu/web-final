package com.feidian.xiang.webfinal.domain.dao;

import com.feidian.xiang.webfinal.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据学号返回学生
     * @param id 学号
     * @return 学生信息
     */
    User findUserById(Long id);
}
