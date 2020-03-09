package com.handsome.leave.dao;

import com.handsome.leave.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * StudentDao
 *
 * @author handsome
 * @date 2020年 03月09日 13:01:03
 */
@Mapper
public interface StudentDao {

	/**
	 * 查询所有学生 
	 * @date 2020/03/09 14:46:13
	 * @author handsome
	 * @param 
	 * @return java.util.List<com.handsome.leave.entity.Student>
	 */        
	List<Student> queryAll();

	/**
	 * 查询单个学生 
	 * @date 2020/03/09 14:46:40
	 * @author handsome
	 * @param studentId
	 * @return com.handsome.leave.entity.Student
	 */        
	Student queryByStudentId(long studentId);

	/**
	 * 更新学生 
	 * @date 2020/03/09 14:46:54
	 * @author handsome
	 * @param student
	 * @return int
	 */        
	int updateByStudent(Student student);

	/**
	 * 增加学生 
	 * @date 2020/03/09 14:48:33
	 * @author handsome
	 * @param student
	 * @return int
	 */        
	int insertByStudent(Student student);
}
