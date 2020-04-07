package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.rest.entity.Student;
import com.luv2code.springdemo.rest.exception.StudentErrorResponse;
import com.luv2code.springdemo.rest.exception.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<Student>();
		theStudents.add(new Student("Pappa", "Geronimo"));
		theStudents.add(new Student("Mamma", "Geronimo"));
		theStudents.add(new Student("Babba", "Geronimo"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable(required = true) int studentId) {
		if(studentId < 0 || studentId >= theStudents.size()) {
			throw new StudentNotFoundException("No Student found for id: " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
}
