package h5EDULive.dao;

import h5EDULive.dao.domain.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer>, JpaSpecificationExecutor<StudentCourse> {
    List<StudentCourse> findByStuId(int stu_id);
    void deleteByCourseIdAndStuId(int course_id, int stu_id);
}