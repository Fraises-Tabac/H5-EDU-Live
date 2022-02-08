package h5EDULive.dao;

import h5EDULive.dao.domain.TeacherCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, Integer>, JpaSpecificationExecutor<TeacherCourse> {

    void deleteByCourseId(int courseId);

}
