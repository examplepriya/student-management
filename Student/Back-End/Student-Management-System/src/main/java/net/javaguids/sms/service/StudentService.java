package net.javaguids.sms.service;

import java.util.List;

import net.javaguids.sms.entity.Student;

public interface StudentService {
	
List<Student>getAllStudent();
	
	void saveStudent(Student student);
	
	Student getStudentById(long id);
	
	void deleteStudentById(long id);


}
