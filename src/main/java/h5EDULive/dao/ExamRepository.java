package h5EDULive.dao;

import h5EDULive.dao.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ExamRepository extends JpaRepository<Exam, Integer>, JpaSpecificationExecutor<Exam> {
    Exam findByCourseId(int courseId);

    void deleteByCourseId(int courseId);
}
