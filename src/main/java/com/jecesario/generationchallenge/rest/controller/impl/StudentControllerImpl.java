package com.jecesario.generationchallenge.rest.controller.impl;

import com.jecesario.generationchallenge.domain.models.Student;
import com.jecesario.generationchallenge.domain.repository.StudentRepository;
import com.jecesario.generationchallenge.domain.vo.StudentRequest;
import com.jecesario.generationchallenge.domain.vo.StudentResponse;
import com.jecesario.generationchallenge.rest.controller.StudentController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentControllerImpl implements StudentController {

    private final StudentRepository studentRepository;

    public StudentControllerImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ResponseEntity<StudentResponse> create(StudentRequest studentRequest) {

        var student = Student.builder()
                .withName(studentRequest.getName())
                .withAge(studentRequest.getAge())
                .withGrade1(studentRequest.getGrade1())
                .withGrade2(studentRequest.getGrade2())
                .withProfessorName(studentRequest.getProfessorName())
                .withClassId(studentRequest.getClassId())
                .build();

        var studentSaved = this.studentRepository.save(student);

        var studentResponse = StudentResponse.builder()
                .withId(studentSaved.getId())
                .withName(studentSaved.getName())
                .withAge(studentSaved.getAge())
                .withGrade1(studentSaved.getGrade1())
                .withGrade2(studentSaved.getGrade2())
                .withProfessorName(studentSaved.getProfessorName())
                .withClassId(studentSaved.getClassId())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(studentResponse);
    }

    @Override
    public ResponseEntity<List<StudentResponse>> findAll() {

        var studentResponse = this.studentRepository.findAll().stream()
                .map(student -> StudentResponse.builder()
                        .withId(student.getId())
                        .withName(student.getName())
                        .withAge(student.getAge())
                        .withGrade1(student.getGrade1())
                        .withGrade2(student.getGrade2())
                        .withProfessorName(student.getProfessorName())
                        .withClassId(student.getClassId())
                        .build()).toList();

        return ResponseEntity.ok(studentResponse);
    }

    @Override
    public ResponseEntity<StudentResponse> findById(Integer id) {
        return this.studentRepository.findById(id).map(student -> {
            var studentFound = StudentResponse.builder()
                    .withId(student.getId())
                    .withName(student.getName())
                    .withAge(student.getAge())
                    .withGrade1(student.getGrade1())
                    .withGrade2(student.getGrade2())
                    .withProfessorName(student.getProfessorName())
                    .withClassId(student.getClassId())
                    .build();
            return ResponseEntity.ok(studentFound);
        }).orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<StudentResponse> edit(Integer id, StudentRequest studentRequest) {
        var student = Student.builder()
                .withId(id)
                .withName(studentRequest.getName())
                .withAge(studentRequest.getAge())
                .withGrade1(studentRequest.getGrade1())
                .withGrade2(studentRequest.getGrade2())
                .withProfessorName(studentRequest.getProfessorName())
                .withClassId(studentRequest.getClassId())
                .build();

        var studentFound = this.studentRepository.save(student);

        var studentResponse = StudentResponse.builder()
                .withId(studentFound.getId())
                .withName(studentFound.getName())
                .withAge(studentFound.getAge())
                .withGrade1(studentFound.getGrade1())
                .withGrade2(studentFound.getGrade2())
                .withProfessorName(studentFound.getProfessorName())
                .withClassId(studentFound.getClassId())
                .build();

        return ResponseEntity.ok(studentResponse);
    }

    @Override
    public void delete(Integer id) {
        this.studentRepository.deleteById(id);
    }
}
