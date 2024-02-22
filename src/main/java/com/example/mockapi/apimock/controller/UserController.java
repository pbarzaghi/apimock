package com.example.mockapi.apimock.controller;

import com.example.mockapi.apimock.dto.UserDto;
import com.example.mockapi.apimock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mockapi/v1/users")
public class UserController {

    @Autowired
   private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser(){
        return new ResponseEntity(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody UserDto userDto){
        userService.save(userDto);

    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("id") Integer id, @RequestBody UserDto userDto){
        userService.update(id,userDto);


    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser( @PathVariable("id") Integer id ) {
        userService.delete(id);
    }

    @GetMapping("/{id}")
        public ResponseEntity<UserDto> findUser(@PathVariable("id") Integer id ){
             return new ResponseEntity<>( userService.findUser(id), HttpStatus.OK);

        }

}



