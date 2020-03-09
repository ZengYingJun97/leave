package com.handsome.leave.dao;

import com.handsome.leave.entity.Instructor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * InstructorDao
 *
 * @author handsome
 * @date 2020年 03月09日 12:45:46
 */
@Mapper
public interface InstructorDao {

	/**
	 * 查询所有辅导员 
	 * @date 2020/03/09 12:59:49
	 * @author handsome
	 * @param 
	 * @return java.util.List<com.handsome.leave.entity.Instructor>
	 */        
	List<Instructor> queryAll();

	/**
	 * 查询单个辅导员 
	 * @date 2020/03/09 13:00:07
	 * @author handsome
	 * @param instructorId
	 * @return com.handsome.leave.entity.Instructor
	 */        
	Instructor queryByInstructorId(long instructorId);

	/**
	 * 更新辅导员信息 
	 * @date 2020/03/09 13:00:29
	 * @author handsome
	 * @param instructor
	 * @return int
	 */        
	int updateByInstructor(Instructor instructor);

	/**
	 * 增加辅导员 
	 * @date 2020/03/09 13:01:34
	 * @author handsome
	 * @param instructor
	 * @return int
	 */        
	int insertByInstructor(Instructor instructor);
}
