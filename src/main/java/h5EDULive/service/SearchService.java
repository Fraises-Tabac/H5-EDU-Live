package h5EDULive.service;

import h5EDULive.dao.domain.Course;
import h5EDULive.dao.domain.Exam;
import h5EDULive.dao.domain.Post;
import h5EDULive.web.dto.PostSummary;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SearchService {
//    List<> getAll(String keywords, Pageable pageable);
    List<Course> getCourses(String keywords, Pageable pageable);
    List<Exam> getExams(String keywords, Pageable pageable);
    List<PostSummary> getPosts(String keywords, Pageable pageable);
}
