package h5EDULive.dao.domain;

import h5EDULive.Util.Serialization;

import javax.persistence.Entity;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "user_exam")
public class UserExam {
//    public UserIdPK getId() {
//        return id;
//    }
//
//    public void setId(UserIdPK id) {
//        this.id = id;
//    }
//
//    @EmbeddedId
//    private UserIdPK id;

    //    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "course_id")
    private int courseId;

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name="answers",columnDefinition="longblob")
    private byte[] answers;//用户的解答

    @Lob
    @Basic(fetch=FetchType.LAZY)
    @Column(name="sub_score",columnDefinition="blob")
    private byte[] subScore;

    @Column(name = "total_score")
    private int totalScore;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public List<Integer> getAnswers() {
        return (List<Integer>) Serialization.byte2obj(answers);
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = Serialization.obj2byte(answers);
    }

    public List<Integer> getSubScore() {
        return (List<Integer>)Serialization.byte2obj(subScore);
    }

    public void setSubScore(List<Integer> subScore) {
        this.subScore = Serialization.obj2byte(subScore);
        this.subScore = Serialization.obj2byte(subScore);
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String message(){
        return getCourseId()+" "+getUserId()+" "+getTotalScore();
    }

}