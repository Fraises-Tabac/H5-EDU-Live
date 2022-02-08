package h5EDULive.service;

import h5EDULive.dao.domain.Course;
import h5EDULive.dao.domain.Exam;
import h5EDULive.dao.domain.Post;
import h5EDULive.dao.domain.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers();
    String removeUser(int userId);
    List<Course> getAllCourses();
    String removeCourse(int courseId);
    List<Exam> getAllExams();
    String removeExam(int courseId);
    List<Post> getAllPosts();
    String removePost(int postId);

}
