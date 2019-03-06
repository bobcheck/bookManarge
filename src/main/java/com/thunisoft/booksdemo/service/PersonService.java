package com.thunisoft.booksdemo.service;

import com.thunisoft.booksdemo.bean.Person;
import com.thunisoft.booksdemo.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonMapper personMapper;

    public List<Person> sel(Person per){
        return personMapper.sel(per);
    }
    public List<Person> all(){
        return personMapper.findAll();
    }
}
