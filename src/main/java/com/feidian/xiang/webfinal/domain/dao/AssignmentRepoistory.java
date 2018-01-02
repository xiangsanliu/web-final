package com.feidian.xiang.webfinal.domain.dao;

import com.feidian.xiang.webfinal.domain.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepoistory extends JpaRepository<Assignment, Long> {
    /**
     * 根据作业名查找作业
     * @param name 作业名
     * @return 作业
     */
    Assignment findAssignmentByName(String name);

}
