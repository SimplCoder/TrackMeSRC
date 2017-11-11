package com.trackme.spring.service;

import java.util.List;

import com.trackme.spring.model.Student;

public interface StudentService {

	public void addStudent(Student p);
	public void updateStudent(Student p);
	public List<Student> listStudents();
	public Student getStudentById(String id);
	public void removeStudent(String id);

	public String uploadStudentRecord(String filepath,String schedule,String dropRouteScheduleId);
	
}
