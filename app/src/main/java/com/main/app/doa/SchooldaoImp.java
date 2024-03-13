package com.main.app.doa;

import com.main.app.entity.School;
import com.main.app.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SchooldaoImp implements Schooldao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public School saveSchool(School school) {
        jdbcTemplate.update("INSERT INTO School(registerNumber,name,address,totalStudent,totalTeacher) values(?,?,?,?,?)",school.getRegisterNumber(),school.getName(),school.getAddress(),school.getTotalStudent(),school.getTotalTeacher());
        return school;
    }

    @Override
    public School updateSchool(School school) {
        jdbcTemplate.update("UPDATE School SET name=?, address=? WHERE registerNumber=?",school.getName(),school.getAddress(),school.getRegisterNumber());
        return school;
    }

    @Override
    public School getByRegisterNumber(int RegisterNumber) {
        return jdbcTemplate.queryForObject("SELECT * FROM School WHERE registerNumber=?",(rs, rowNow) ->{
            return new School(rs.getInt("registerNumber"),rs.getString("name"),rs.getString("address"),rs.getInt("totalStudent"),rs.getInt("totalTeacher"));
        },RegisterNumber);
    }

    @Override
    public String deleteByRegisterNumber(int RegisterNumber) {
        jdbcTemplate.update("DELETE FROM School WHERE registerNumber=?",RegisterNumber);
        return "School got deleted with RegisterNumber " + RegisterNumber;
    }

    @Override
    public List<School> allSchool() {
        return jdbcTemplate.query("SELECT * FROM School", (rs, rowNum) -> {
            return new School(rs.getInt("registerNumber"), rs.getString("name"), rs.getString("address"), rs.getInt("totalStudent"),rs.getInt("totalTeacher"));
        });
    }
}
