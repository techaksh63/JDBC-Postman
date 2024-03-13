package com.main.app.doa;

import com.main.app.entity.Student;
import com.main.app.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TeacherdaoImp implements Teacherdao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Teacher saveTeacher(Teacher teacher) {
        jdbcTemplate.update("INSERT INTO Teacher(id,name,address,salary) values(?,?,?,?)",teacher.getId(),teacher.getName(),teacher.getAddress(),teacher.getSalary());
        return teacher;
    }

    @Override
    public Teacher updateTeacherName(Teacher teacher) {
        jdbcTemplate.update("UPDATE Teacher SET name=? WHERE id=?",teacher.getName(),teacher.getId());
        return teacher;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        jdbcTemplate.update("UPDATE Teacher SET name=?, address=?, salary=? WHERE id=?",teacher.getName(),teacher.getAddress(),teacher.getSalary(),teacher.getId());
        return teacher;
    }

    @Override
    public Teacher getByID(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Teacher WHERE id=?",(rs, rowNow) ->{
            return new Teacher(rs.getInt("id"),rs.getString("name"),rs.getString("address"),rs.getInt("salary"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update("DELETE FROM Teacher WHERE id=?",id);
        return "Teacher got deleted with id " + id;
    }

    @Override
    public List<Teacher> allTeacher() {
        return jdbcTemplate.query("SELECT * FROM Teacher", (rs, rowNum) -> {
            return new Teacher(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getInt("salary"));
        });
    }
}
