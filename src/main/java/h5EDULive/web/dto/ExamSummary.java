package h5EDULive.web.dto;

public class ExamSummary {
    private int courseId;
    private String name;
    private String coursePic;
    private String time;
    private int maxScore;
    private int totalScore;

    public ExamSummary(int courseId, String name, String coursePic, String time, int maxScore, int totalScore) {
        this.courseId = courseId;
        this.name = name;
        this.coursePic = coursePic;
        this.time = time;
        this.maxScore = maxScore;
        this.totalScore = totalScore;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoursePic() {
        return coursePic;
    }

    public void setCoursePic(String coursePic) {
        this.coursePic = coursePic;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
