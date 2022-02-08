package h5EDULive.service;

import h5EDULive.dao.domain.Course;

import java.util.List;

public interface TeacherCourseService {
    List<Course> getList(int id);

    boolean insert(int tchId, int courseId);

    void delete(int courseId);

    void modifyInfo(int courseId, String dep);

    boolean upload();
}
