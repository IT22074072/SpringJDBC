package org.example.springjdbc.repo;

import org.example.springjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s){

        String sql = "insert into student (rollno, name, marks) values(?,?,?)";
        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks()); //update return type is int- no of rows affected
        System.out.println(rows+ " affected");



    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        return students;
    }
}
