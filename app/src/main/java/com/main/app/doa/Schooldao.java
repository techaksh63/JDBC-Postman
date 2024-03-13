package com.main.app.doa;

import com.main.app.entity.School;

import java.util.List;

public interface Schooldao {
        School saveSchool(School school);
        School updateSchool(School school);
        School getByRegisterNumber(int RegisterNumber);
        String deleteByRegisterNumber(int RegisterNumber);
        List<School> allSchool();
}
