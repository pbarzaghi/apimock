package com.example.mockapi.apimock.service;

import com.example.mockapi.apimock.dto.UserDto;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${spring.external.service.base-url}")
    private String basePath;

    private final RestTemplate restTemplate;


    public List<UserDto> getAll(){
        UserDto[] response=restTemplate.getForObject(basePath+"/users",UserDto[].class);

        return Arrays.asList(response);
    }
      public UserDto  findUser(Integer id){
        return restTemplate.getForObject(basePath+"/users/"+id,UserDto.class);

      }
    public void save(UserDto userDto){
        restTemplate.postForObject(basePath+"/users",userDto,UserDto.class);
      }
    public void update(Integer id,UserDto userDto){
           restTemplate.put(basePath+"/users/"+id,userDto);

        }

    public void delete(Integer id){
            restTemplate.delete(basePath+"users/"+id);
    }
}
