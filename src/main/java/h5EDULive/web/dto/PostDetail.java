package h5EDULive.web.dto;

import h5EDULive.dao.domain.Response;

import java.util.List;

public class PostDetail {
    private String title;
    private String author;
    private int heat;
    private String body;
    private String pubTime;
    private List<Response> responses;

    public PostDetail(String title, String author, int heat, String body, String pubTime, List<Response> responses) {
        this.title = title;
        this.author = author;
        this.heat = heat;
        this.body = body;
        this.pubTime = pubTime;
        this.responses = responses;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPubTime() {
        return pubTime;
    }

    public void setPubTime(String pubTime) {
        this.pubTime = pubTime;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
