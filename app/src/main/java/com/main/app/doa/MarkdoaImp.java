package com.main.app.doa;

import com.main.app.entity.Marks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MarkdoaImp implements Markdao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Marks saveMarks(Marks marks) {
        jdbcTemplate.update("INSERT INTO Marks(registerNumber,rollNumber,marks,resultStatus) values(?,?,?,?)",marks.getRegisterNumber(),marks.getRollNumber(),marks.getMarks(),marks.getResultStatus());
        return marks;
    }

    @Override
    public Marks updateMarks(Marks marks) {
        jdbcTemplate.update("UPDATE Marks SET marks=?, resultStatus=? WHERE rollNumber=?",marks.getMarks(),marks.getResultStatus(),marks.getRollNumber());
        return marks;
    }

    @Override
    public Marks getByRollNumber(int rollNumber) {
        return jdbcTemplate.queryForObject("SELECT * FROM Marks WHERE rollNumber=?",(rs, rowNow) ->{
            return new Marks(rs.getInt("registerNumber"),rs.getInt("rollNumber"),rs.getInt("marks"),rs.getString("resultStatus"));
        },rollNumber);
    }

    @Override
    public String deleteByRollNumber(int rollNumber) {
        jdbcTemplate.update("DELETE FROM Marks WHERE rollNumber=?",rollNumber);
        return "Marks got deleted with rollNumber " + rollNumber;
    }

    @Override
    public List<Marks> allMarks() {
        return jdbcTemplate.query("SELECT * FROM Marks", (rs, rowNum) -> {
            return new Marks(rs.getInt("registerNumber"),rs.getInt("rollNumber"),rs.getInt("marks"),rs.getString("resultStatus"));
        });
    }
}
