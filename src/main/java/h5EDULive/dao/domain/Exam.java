package h5EDULive.dao.domain;

import h5EDULive.Util.Serialization;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId;
    private String time;
    private int duration;

    @Column(name = "max_score")
    private int maxScore;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name="subtitle_score",columnDefinition="blob")
    private byte[] subtitleScore;//每题的分数

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name="solutions",columnDefinition="blob")
    private byte[] solutions;//每题的答案

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name="picurl",columnDefinition="blob")
    private byte[] subtitlePicUrl;//每题的url

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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


    public List<Integer> getSubtitleScore() {
        return (List<Integer>) Serialization.byte2obj(subtitleScore);
    }

    public void setSubtitleScore(List<Integer> subtitleScore) {
        this.subtitleScore = Serialization.obj2byte(subtitleScore);
    }

    public List<Integer> getSolutions() {
        return (List<Integer>) Serialization.byte2obj(solutions);
    }

    public void setSolutions(List<Integer> solutions) {
        this.solutions = Serialization.obj2byte(solutions);
    }

    public List<String> getSubtitlePicUrl() {
        return (List<String>) Serialization.byte2obj(subtitlePicUrl);
    }

    public void setSubtitlePicUrl(List<String> subtitlePicUrl) {
        this.subtitlePicUrl = Serialization.obj2byte(subtitlePicUrl);
    }

    public String message(){
        return getTime()+" "+getMaxScore()+" "+getCourseId()+" "+getDuration();
    }

}
