package com.handsome.leave.service;

import com.handsome.leave.entity.Student;

/**
 * StudentService
 *
 * @author handsome
 * @date 2020年 03月13日 13:27:25
 */
public interface StudentService {

	/**
	 * 验证学生登陆
	 * @date 2020/03/13 15:44:02
	 * @author handsome
	 * @param student
	 * @return com.handsome.leave.entity.Student 返回加密信息
	 */
	Student login(Student student);

	/**
	 * 获取学生基本信息 
	 * @date 2020/03/13 15:46:16
	 * @author handsome
	 * @param studentId
	 * @return com.handsome.leave.entity.Student
	 */        
	Student getByStudentId(long studentId);
}
