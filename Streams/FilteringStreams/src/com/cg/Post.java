package com.cg;

public class Post {

    private String title;
    private int likes;

    public Post(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public int getLikes() {
        return likes;
    }
}
