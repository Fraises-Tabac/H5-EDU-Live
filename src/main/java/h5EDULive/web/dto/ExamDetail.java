package h5EDULive.web.dto;

import java.util.List;

public class ExamDetail {
    private String name;
    private String label;
    private String lecture;
    private String time;
    private int duration;
    private int maxScore;
    private List<String> subtitle;
    private List<Integer> subtitleScore;
    private List<Integer> solutions;
    private List<Integer> answers;
    private List<Integer> subScore;
    private int totalScore;

    public ExamDetail(String name, String label, String lecture, String time, int duration, int maxScore, List<String> subtitle, List<Integer> subtitleScore, List<Integer> solutions, List<Integer> answers, List<Integer> subScore, int totalScore) {
        this.name = name;
        this.label = label;
        this.lecture = lecture;
        this.time = time;
        this.duration = duration;
        this.maxScore = maxScore;
        this.subtitle = subtitle;
        this.subtitleScore = subtitleScore;
        this.solutions = solutions;
        this.answers = answers;
        this.subScore = subScore;
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLecture() {
        return lecture;
    }

    public void setLecture(String lecture) {
        this.lecture = lecture;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public List<String> getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(List<String> subtitle) {
        this.subtitle = subtitle;
    }

    public List<Integer> getSubtitleScore() {
        return subtitleScore;
    }

    public void setSubtitleScore(List<Integer> subtitleScore) {
        this.subtitleScore = subtitleScore;
    }

    public List<Integer> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Integer> solutions) {
        this.solutions = solutions;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    public List<Integer> getSubScore() {
        return subScore;
    }

    public void setSubScore(List<Integer> subScore) {
        this.subScore = subScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }
}
