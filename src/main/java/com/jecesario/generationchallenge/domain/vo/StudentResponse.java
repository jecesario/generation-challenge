package com.jecesario.generationchallenge.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class StudentResponse {
    private Integer id;
    private String name;
    private Integer age;
    private Double grade1;
    private Double grade2;
    private String professorName;
    private String classId;
}
