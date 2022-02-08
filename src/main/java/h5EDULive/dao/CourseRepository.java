package h5EDULive.dao;

import h5EDULive.dao.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer>, JpaSpecificationExecutor<Course> {
    Course findByCourseId(int course_id);

    Course findByName(String name);

    List<Course> findAll();

    @Query(value = "select name from course where course_id in (select course_id from stu_Course where stu_id=1)",nativeQuery = true)
    List<String> findNameByCourseId(int course_id);

    void deleteByCourseId(int course_id);

    @Modifying
    @Query(value = "update course set name=?2 where course_id=?1",nativeQuery = true)
    void updateNameByCourseId(int courseId, String name);

    @Query(value = "update course set depiction=?2 where course_id=?1",nativeQuery = true)
    @Modifying
    void updateDepictionByCourseId(int courseId, String depiction);

    @Modifying
    @Query(value = "update course set label=?2 where course_id=?1",nativeQuery = true)
    void updateLabelByCourseId(int courseId, String label);

    @Query(value = "select * from course where course_id in (select course_id from teacher_course where teacher_id=?1)",nativeQuery = true)
    List<Course> getList(int id);

    @Query(value = "select * from course where concat(name,lecture,depiction;label) regexp ?1",nativeQuery = true)
    Page<Course> findByKeys(String regex, Pageable pageable);

}

