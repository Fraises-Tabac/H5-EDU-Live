package h5EDULive.service;


import h5EDULive.dao.domain.Course;

import java.util.List;

public interface StudentCourseService {

    List<Course> getList(int id);

    boolean insert(int stuId, int courseId);

    void remove(int stuId, int courseId);

    String getInfo(int id);

    String getRecord(int id);
}
