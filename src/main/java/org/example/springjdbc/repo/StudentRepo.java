package org.example.springjdbc.repo;

import org.example.springjdbc.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    public void save(){

        System.out.println("Saved");


    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}
