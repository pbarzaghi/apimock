package com.example.mockapi.apimock.client;

import com.example.mockapi.apimock.configuration.FeignClientConfig;
import com.example.mockapi.apimock.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "STUDENT-MOCK-API",
        url="${spring.external.service.base-url}",
        configuration = FeignClientConfig.class)

public interface StudentFeignClient {

    @GetMapping(value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<StudentDto> getStudents();


    @PostMapping (value = "/student", consumes = MediaType.APPLICATION_JSON_VALUE)
    StudentDto saveStudent(@RequestBody StudentDto studentDto);

    @PutMapping(value = "/student/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto);

    @DeleteMapping(value = "/student/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    void deleteStudent(@PathVariable Integer id);






     @GetMapping(value = "/student/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
      StudentDto findStudents(@PathVariable Integer id);


}
