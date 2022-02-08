package h5EDULive.dao;

import h5EDULive.dao.domain.CourseStream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created on 2019-7-8.
 */
public interface LiveRepository extends JpaRepository<CourseStream, Integer>, JpaSpecificationExecutor<CourseStream> {

    CourseStream findByCourseId(int courseId);

    void deleteByCourseId(int courseId);

}
