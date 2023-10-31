package com.jecesario.generationchallenge.domain.repository;

import com.jecesario.generationchallenge.domain.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
