package org.example.springjdbc.repo;

import org.example.springjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
        String sql = "select * from student";

        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException { //mapRow will fetch the result set and let us to take those data and add them to the student object and return it

                Student s = new Student();
                s.setRollNo(rs.getInt("rollno"));
                s.setName(rs.getString("name"));
                s.setMarks(rs.getInt("marks"));
                return s;
            }
        };

        return jdbc.query(sql, mapper);
    }
}
