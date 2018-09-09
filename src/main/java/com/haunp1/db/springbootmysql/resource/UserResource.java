package com.haunp1.db.springbootmysql.resource;

import com.haunp1.db.springbootmysql.model.Users;
import com.haunp1.db.springbootmysql.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "rest/users")
public class UserResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll(){
        return usersRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Users> persist(@RequestBody final Users users){
        usersRepository.save(users);
        return usersRepository.findAll();
    }
}
