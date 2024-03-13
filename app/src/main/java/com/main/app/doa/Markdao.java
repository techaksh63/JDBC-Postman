package com.main.app.doa;

import com.main.app.entity.Marks;

import java.util.List;

public interface Markdao {
    Marks saveMarks(Marks marks);
    Marks updateMarks(Marks marks);
    Marks getByRollNumber(int rollNumber);
    String deleteByRollNumber(int rollNumber);
    List<Marks> allMarks();
}
