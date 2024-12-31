package org.example.springjdbc;

import org.example.springjdbc.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
        Student s = context.getBean(Student.class);
        s.setRollNo(101);
        s.setName("Dinithi");
        s.setMarks(98);

    }

}
