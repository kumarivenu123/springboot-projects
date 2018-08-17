package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;
import com.test.service.TestService;

@RestController
public class TestController {

	@Autowired
	TestService testService;

	// save student
	@PostMapping("/save/student")
	public String saveStudent(@RequestBody Student student) {
		Integer result = testService.saveStudent(student);
		return "Student ID : " + result;
	}

	// find one student
	@GetMapping("/find/student")
	public Student findStudent(@RequestParam Integer studentId) {
		Student student = testService.findStudent(studentId);
		return student;
	}

	// find all student
	@GetMapping("/find/student/all")
	public List<Student> findAllStudent() {
		List<Student> students = testService.findAllStudent();
		return students;
	}

	@GetMapping("/saywelcome")
	public Student sayWelcome() {
		return null;
	}

}
