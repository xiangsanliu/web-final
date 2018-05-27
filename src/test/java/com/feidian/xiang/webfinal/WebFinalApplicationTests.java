package com.feidian.xiang.webfinal;

import com.feidian.xiang.webfinal.dao.entity.Assignment;
import com.feidian.xiang.webfinal.dao.mapper.AssignmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebFinalApplicationTests {

	@Resource
    private
    AssignmentMapper assignmentMapper;

	@Test
	public void contextLoads() {
        List<Assignment> list = assignmentMapper.listAll();
        System.out.println(list);
        System.out.println(assignmentMapper.exists(2L));
	}

}
