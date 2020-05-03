package com.handsome.leave.controller;

import com.handsome.leave.dto.LeaveResult;
import com.handsome.leave.entity.Instructor;
import com.handsome.leave.entity.Student;
import com.handsome.leave.service.impl.InstructorServiceImpl;
import com.handsome.leave.service.impl.StudentServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * LeaveController
 *
 * @author handsome
 * @date 2020年 03月16日 23:43:18
 */
@RestController
@RequestMapping("/leave")
public class LeaveController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private StudentServiceImpl studentService;

	@Autowired
	private InstructorServiceImpl instructorService;

	@RequestMapping(value = "/getstudent", method = RequestMethod.GET)
	public Map<String, Object> getStudentById(long studentId) {
		Student student = studentService.getByStudentId(studentId);
		Map<String, Object> result = new HashMap<>();
		result.put("student", student);
		return result;
	}

	@RequestMapping(value = "/getinstructor", method = RequestMethod.GET)
	public Map<String, Object> getInstructorById(long instructorId) {
		Instructor instructor = instructorService.getByInstructorId(instructorId);
		Map<String, Object> result = new HashMap<>();
		result.put("instructor", instructor);
		return result;
	}

	@RequestMapping(value = "/student/login",
			method = RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public LeaveResult<Student> loginStudent(@Param("account") String account, @Param("password") String password, HttpServletRequest request) {
		Student student = new Student();
		student.setStudentAccount(account);
		student.setStudentPassword(password);
		Student studentLogin = studentService.login(student);

		LeaveResult<Student> result = null;
		if (studentLogin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("password", studentLogin.getStudentPassword());
			studentLogin.setStudentPassword(null);
			result = new LeaveResult<>(true, studentLogin);
		} else {
			result = new LeaveResult<>(false, "登陆失败");
		}
		return result;
	}//curl -H "Accept: application/json" -H "Content-Type:application/json" -X POST -d '{"username": "std0000001", "password": "123456"}' http://127.0.0.1:8081/leave/student/login

	@RequestMapping(value = "/instructor/login",
			method = RequestMethod.POST,
			produces = "application/json;charset=UTF-8")
	@ResponseBody
	public LeaveResult<Instructor> loginInstructor(@Param("account") String account, @Param("password") String password, HttpServletRequest request) {
		Instructor instructor = new Instructor();
		instructor.setInstructorAccount(account);
		instructor.setInstructorPassword(password);
		Instructor instructorLogin = instructorService.login(instructor);

		LeaveResult<Instructor> result = null;
		if (instructorLogin != null) {
			HttpSession session = request.getSession();
			session.setAttribute("password", instructorLogin.getInstructorPassword());
			instructorLogin.setInstructorPassword(null);
			result = new LeaveResult<>(true, instructorLogin);
		} else {
			result = new LeaveResult<>(false, "登陆失败");
		}
		return result;
	}
}
