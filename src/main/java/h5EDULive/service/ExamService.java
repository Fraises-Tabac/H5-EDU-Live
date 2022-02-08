package h5EDULive.service;

import h5EDULive.web.dto.ExamDetail;
import h5EDULive.web.dto.ExamSummary;
import h5EDULive.dao.domain.UserExam;

import java.util.List;

public interface ExamService {
    List<ExamSummary> getExamSummaries(int userId);
    ExamDetail getExamDetail(int userId, int courseId);
    List<Integer> getExamResult(UserExam userExam);
    String addExam(String examInfo);
    String removeExam(int courseId);
}
