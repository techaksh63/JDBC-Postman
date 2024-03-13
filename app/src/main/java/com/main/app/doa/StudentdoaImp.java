package com.main.app.doa;

import com.main.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentdoaImp implements Studentdoa{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Student saveStudent(Student student) {
        jdbcTemplate.update("INSERT INTO Student(rollNumber,name,address,standard) values(?,?,?,?)",student.getRollNumber(),student.getName(),student.getAddress(),student.getStandard());
        return student;
    }

    @Override
    public Student updateStudentName(Student student) {
        jdbcTemplate.update("UPDATE Student SET name=? WHERE rollNumber=?",student.getName(),student.getRollNumber());
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        jdbcTemplate.update("UPDATE Student SET name=?, address=?, standard=? WHERE rollNumber=?",student.getName(),student.getAddress(),student.getStandard(),student.getRollNumber());
        return student;
    }

    @Override
    public Student getByID(int rollNumber) {
        return jdbcTemplate.queryForObject("SELECT * FROM Student WHERE rollNumber=?",(rs, rowNow) ->{
           return new Student(rs.getInt("rollNumber"),rs.getString("name"),rs.getString("address"),rs.getString("standard"));
        },rollNumber);
    }


    @Override
    public String deleteById(int rollNumber) {
        jdbcTemplate.update("DELETE FROM Student WHERE rollNumber=?",rollNumber);
        return "Student got deleted with rollNumber " + rollNumber;
    }

    @Override
    public List<Student> allStudent() {
        return jdbcTemplate.query("SELECT * FROM Student", (rs, rowNum) -> {
            return new Student(rs.getInt("rollNumber"), rs.getString("name"), rs.getString("address"), rs.getString("standard"));
        });
    }
}
