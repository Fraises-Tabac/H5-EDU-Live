package h5EDULive.dao.domain;

import javax.persistence.*;

@Entity
@Table(name = "response")
public class Response {

    @Id
    @Column(name = "res_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resId;
    private int pId;
    private String responder;
    private String respondTime;
    private String content;
    private int like;
    private int dislike;

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getResponder() {
        return responder;
    }

    public void setResponder(String responder) {
        this.responder = responder;
    }

    public String getRespondTime() {
        return respondTime;
    }

    public void setRespondTime(String respondTime) {
        this.respondTime = respondTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
