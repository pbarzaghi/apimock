package com.example.mockapi.apimock.controller;

import com.example.mockapi.apimock.dto.StudentDto;
import com.example.mockapi.apimock.dto.UserDto;
import com.example.mockapi.apimock.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mockapi/v1/student")

@RequiredArgsConstructor
public class StudentController {


    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllUser(){
        return new ResponseEntity(studentService.getAll(), HttpStatus.OK);
    }

    @PostMapping

    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.save(studentDto), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("id") Integer id, @RequestBody StudentDto studentDto){
        studentService.update(id,studentDto);


    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser( @PathVariable("id") Integer id ) {
        studentService.delete(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findUser(@PathVariable("id") Integer id ){
        return new ResponseEntity<>( studentService.findStudent(id), HttpStatus.OK);

    }


}
