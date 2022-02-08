package h5EDULive.web.dto;

public class PostSummary {
    private int postId;
    private String title;
    private String author;
    private int heat;
    private String pubTime;
    private String latestTime;

    public PostSummary(int postId, String title, String author, int heat, String pubTime, String latestTime) {
        this.postId = postId;
        this.title = title;
        this.author = author;
        this.heat = heat;
        this.pubTime = pubTime;
        this.latestTime = latestTime;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public String getLatestTime() {
        return latestTime;
    }

    public void setLatestTime(String latestTime) {
        this.latestTime = latestTime;
    }
}
