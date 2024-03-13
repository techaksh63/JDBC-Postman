package com.main.app.doa;

import com.main.app.entity.Teacher;

import java.util.List;

public interface Teacherdao {
    Teacher saveTeacher(Teacher teacher);
    Teacher updateTeacherName(Teacher teacher);
    Teacher updateTeacher(Teacher teacher);
    Teacher getByID(int id);
    String deleteById(int id);
    List<Teacher> allTeacher();

}
