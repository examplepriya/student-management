package net.javaguids.sms.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import net.javaguids.sms.entity.Student;
import net.javaguids.sms.repository.StudentRepository;

public class StudentServiceImpl implements StudentService  {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	@Override
	public void saveStudent(Student student) {
		this.studentRepository.save(student);
	}
	
	@Override
	public Student getStudentById(long id) {
		java.util.Optional<Student> optional=studentRepository.findById(id);
		Student student=null;
		if(optional.isPresent()) {
			student=optional.get();
		}
		else {
			throw new RuntimeException("Employee not found for id::"+id);
		}
		return student;
	}
	
	@Override
	public void deleteStudentById(long id) {
		this.studentRepository.deleteById(id);
	}

}

