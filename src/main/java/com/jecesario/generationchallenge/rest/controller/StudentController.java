package com.jecesario.generationchallenge.rest.controller;

import com.jecesario.generationchallenge.domain.vo.StudentRequest;
import com.jecesario.generationchallenge.domain.vo.StudentResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Students", description = "Make Students operations")
public interface StudentController {

    @Operation(description = "Register a student")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Return a student recently registered"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PostMapping
    ResponseEntity<StudentResponse> create(@Valid @RequestBody StudentRequest studentRequest);

    @Operation(description = "Find all students")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Return a student list"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    ResponseEntity<List<StudentResponse>> findAll();

    @Operation(description = "Find a student by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Return a student based on id"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping(value = "/{id}")
    ResponseEntity<StudentResponse> findById(@PathVariable Integer id);

    @Operation(description = "Delete a student by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Return no content"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @PutMapping(value = "/{id}")
    ResponseEntity<StudentResponse> edit(@PathVariable Integer id, @Valid @RequestBody StudentRequest studentRequest);

    @Operation(description = "Delete a student by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Return no content"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Integer id);

}
