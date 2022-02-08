package h5EDULive.dao.domain;

import javax.persistence.*;

@Entity
@Table(name = "post_response")
public class PostResponse {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "res_id")
    private int resId;

    public int getId() {
        return id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}

