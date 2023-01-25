package net.javaguids.sms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguids.sms.entity.Student;
import net.javaguids.sms.exception.ResourceNotFoundException;
import net.javaguids.sms.repository.StudentRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/api/v1/")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	@GetMapping("/students")
	public List<Student>getAllStudents() {
		return studentRepository.findAll();
	}
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student = studentRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Student not exist with id:"+id));
		return ResponseEntity.ok(student);
	}
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student studentDetails){
		Student student = studentRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Student not exist with id:"+id));
		student.setregNo(studentDetails.getregNo());
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setdob(studentDetails.getdob());
		student.setEmail(studentDetails.getEmail());
		Student updateStudent = studentRepository.save(student);
		return ResponseEntity.ok(updateStudent);
	}
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String,Boolean>>deleteStudent(@PathVariable Long id){
		Student student = studentRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Student not exist with id:"+id));
		studentRepository.delete(student);
		Map<String, Boolean> response=new HashMap<>();
		response.put("delete", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
