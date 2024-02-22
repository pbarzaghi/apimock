package com.example.mockapi.apimock.service;

import com.example.mockapi.apimock.client.StudentFeignClient;
import com.example.mockapi.apimock.dto.StudentDto;
import com.example.mockapi.apimock.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {


    private final StudentFeignClient studentFeignClient;

    public List<StudentDto> getAll(){

        return studentFeignClient.getStudents();
    }
    public StudentDto  findStudent(Integer id){
        return studentFeignClient.findStudents(id);

    }
    public StudentDto save(StudentDto studentDto){
       return studentFeignClient.saveStudent(studentDto);

    }
    public void update(Integer id,StudentDto studentDto){
       studentFeignClient.updateStudent(id,studentDto);

    }

    public void delete(Integer id){
       studentFeignClient.deleteStudent(id);
    }
}
