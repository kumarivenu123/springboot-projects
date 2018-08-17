package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Student;
import com.test.repository.TestRepository;

@Service
public class TestService {

	@Autowired
	TestRepository testRepository;

	public Integer saveStudent(Student student) {
		Student stu = testRepository.save(student);
		return stu != null ? stu.getStudentId() : null;
	}

	public Student findStudent(Integer studentId) {
		return testRepository.getOne(studentId);
	}

	public List<Student> findAllStudent() {
		return testRepository.findAll();
	}

}
