package com.trackme.spring.dao;

import java.util.List;

import com.trackme.spring.model.Student;

public interface StudentDAO {

	public void addStudent(Student student);
	public void updateStudent(Student student);
	public List<Student> listStudent();
	public Student getStudentById(String id);
	public void removeStudent(String id);
	public String uploadStudentRecord(String filepath);
	public String uploadStudentRecordWithSchedule(String filepath, String schedule,String dropRouteScheduleId);
}
