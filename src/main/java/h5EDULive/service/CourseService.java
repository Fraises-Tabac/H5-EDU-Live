package h5EDULive.service;


import h5EDULive.dao.domain.Course;

import java.util.List;

public interface CourseService {
    boolean insert(Course course);

    List<Course> getList();

    Course getInfo(int courseId);
}
