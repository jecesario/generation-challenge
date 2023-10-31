package com.jecesario.generationchallenge.domain.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class StudentRequest {

    @Schema(name = "name", defaultValue = "Martchelo", description = "Name of a student")
    @Length(min = 4, max = 20, message = "The 'name' field must be between 3 and 50 characters")
    @NotBlank(message = "The 'name' field must be filled")
    private String name;

    @Schema(name = "age", defaultValue = "99", description = "Age of a student")
    @Min(value = 1, message = "The 'age' field must be greater or equal than 1")
    @Max(value = 123, message = "The 'age' field must be less or equal than 123")
    private Integer age;

    @Schema(name = "grade1", defaultValue = "9.99", description = "A grade of a student")
    @Min(value = 0, message = "The 'grade1' field must be greater or equal than 0")
    @Max(value = 10, message = "The 'grade1' field must be less or equal than 10")
    private Double grade1;

    @Schema(name = "grade2", defaultValue = "8.99", description = "A grade of a student")
    @Min(value = 0, message = "The 'grade2' field must be greater or equal than 0")
    @Max(value = 10, message = "The 'grade2' field must be less or equal than 10")
    private Double grade2;

    @Schema(name = "professorName", defaultValue = "Abaixa os coreano", description = "Name of a professor")
    @Length(min = 3, max = 50, message = "The 'professorName' field must be between 3 and 50 characters")
    @NotBlank(message = "The 'professorName' field must be filled")
    private String professorName;

    @Schema(name = "classId", defaultValue = "TURMA16", description = "Identification of a class")
    @Length(min = 3, max = 50, message = "The 'classId' field must be between 3 and 50 characters")
    @NotBlank(message = "The 'classId' field must be filled")
    private String classId;
}
