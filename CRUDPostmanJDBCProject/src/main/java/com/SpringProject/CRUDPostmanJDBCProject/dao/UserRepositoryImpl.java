package com.SpringProject.CRUDPostmanJDBCProject.dao;

import com.SpringProject.CRUDPostmanJDBCProject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User saveUser(User user) {
        jdbcTemplate.update("INSERT INTO USER(id,fname,lname,email) values(?,?,?,?)", user.getId(), user.getFname(), user.getLname(), user.getEmail());
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update("UPDATE USER SET fname=? WHERE ID=?", user.getFname(), user.getId());
        return user;
    }

    @Override
    public User getById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE ID=?", (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        },id);
    }

    @Override
    public String deleteById(int id) {
        jdbcTemplate.update("DELETE FROM USER WHERE ID=?", id);
        return "User got deleted with id " + id;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query("SELECT * FROM USER", (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        });
    }
}
