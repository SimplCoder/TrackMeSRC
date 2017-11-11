package com.trackme.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trackme.constants.Constant;
import com.trackme.spring.dao.StudentDAO;
import com.trackme.spring.dao.UserMasterDAO;
import com.trackme.spring.model.Student;
import com.trackme.spring.model.UserMaster;

@Service("studentService")

public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO studentDAO;

	

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}


	@Override
	@Transactional
	public void addStudent(Student p) {
		studentDAO.addStudent(p);
	}

	@Override
	@Transactional
	public void updateStudent(Student p) {
		studentDAO.updateStudent(p);
	}

	@Override
	@Transactional
	public List<Student> listStudents() {
		return studentDAO.listStudent();
	}

	@Override
	@Transactional
	public Student getStudentById(String id) {
		
		return studentDAO.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(String id) {
		Student student= studentDAO.getStudentById(id);
		student.setStatus(Constant.STATUS_INACTIVE);
		studentDAO.updateStudent(student);
		
	}

	@Override
	@Transactional
	public String uploadStudentRecord(String filepath,String schedule ,String dropRouteScheduleId) {
		// TODO Auto-generated method stub
		if(schedule !=null && !"".equals(schedule))
			return studentDAO.uploadStudentRecordWithSchedule(filepath, schedule,dropRouteScheduleId);
		else
			return studentDAO.uploadStudentRecord(filepath);
		
	}

}
