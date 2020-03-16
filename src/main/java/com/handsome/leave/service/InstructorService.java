package com.handsome.leave.service;

import com.handsome.leave.entity.Instructor;

/**
 * InstructorService
 *
 * @author handsome
 * @date 2020年 03月16日 23:07:24
 */
public interface InstructorService {

	/**
	 * 验证辅导员登陆 
	 * @date 2020/03/16 23:09:35
	 * @author handsome
	 * @param instructor
	 * @return com.handsome.leave.entity.Instructor
	 */        
	Instructor login(Instructor instructor);
	
	/**
	 * 获取辅导员基本信息 
	 * @date 2020/03/16 23:09:58
	 * @author handsome
	 * @param instructorId
	 * @return com.handsome.leave.entity.Instructor
	 */        
	Instructor getByInstructorId(long instructorId);
}
