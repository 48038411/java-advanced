package com.soft1841.list;

import java.util.Date;

public class Article {
    private Integer id;
    private String title;
    private String author;
    private Date writeTime;

    public Article(Integer id, String title, String author, Date writeTime) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.writeTime = writeTime;
    }

    public Article() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getWriteTime() {
        return writeTime;
    }

    public void setWriteTime(Date writeTime) {
        this.writeTime = writeTime;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", writeTime=" + writeTime +
                '}';
    }
}
