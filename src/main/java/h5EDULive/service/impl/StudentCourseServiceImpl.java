package h5EDULive.service.impl;

import h5EDULive.dao.CourseRepository;
import h5EDULive.dao.StudentCourseRepository;
import h5EDULive.dao.domain.Course;
import h5EDULive.dao.domain.StudentCourse;
import h5EDULive.service.StudentCourseService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
    private final StudentCourseRepository stuCourseRepository;
    private final CourseRepository courseRepository;

    public StudentCourseServiceImpl(StudentCourseRepository stuCourseRepository, CourseRepository courseRepository) {
        this.stuCourseRepository = stuCourseRepository;
        this.courseRepository = courseRepository;
    }

    /* 根据学生id查找课程名称列表 */
    public List<Course> getList(int id)
    {
        List<StudentCourse> courseId = stuCourseRepository.findByStuId(id);
        List<Course> courses = new ArrayList<>();
        for (StudentCourse studentCourse : courseId) {
            courses.add(courseRepository.findByCourseId(studentCourse.getCourseId()));
        }
        return courses;
    }

    /* 把课程添加到我的课程里 */
    @Override
    public boolean insert(int stuId, int courseId)
    {
        StudentCourse stuCourseMapper = new StudentCourse();
        stuCourseMapper.setStuId(stuId);
        stuCourseMapper.setCourseId(courseId);
        return stuCourseRepository.save(stuCourseMapper) != null;
    }

    /* 把课程从我的课程里删除 */
    @Transactional
    @Override
    public void remove(int stuId, int courseId)
    {
        stuCourseRepository.deleteByCourseIdAndStuId(courseId, stuId);
    }

    /* 根据课程id查找课程信息 */
    public String getInfo(int courseId)
    {
        return courseRepository.findByCourseId(courseId).getDepiction();
    }

    /* 根据课程id查找课程录播 */
    public String getRecord(int courseId)
    {
        return courseRepository.findByCourseId(courseId).getVideo();
    }
}
