package h5EDULive.service.impl;

import h5EDULive.dao.CourseRepository;
import h5EDULive.dao.domain.Course;
import h5EDULive.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseRepository courseRepository;

    @Override
    public List<Course> getList() {
        return courseRepository.findAll();
    }

    @Override
    public boolean insert(Course course) {
        return courseRepository.save(course) != null;
    }

    @Override
    public Course getInfo(int courseId) {
        return courseRepository.findByCourseId(courseId);
    }
}
