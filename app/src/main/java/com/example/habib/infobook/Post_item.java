package com.example.habib.infobook;

/**
 * Created by Habib on 8/29/17.
 */

public class Post_item {
    String post;
    String image;
    String comment;

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post_item(String post, String image, String comment) {
        this.post = post;
        this.image = image;
        this.comment = comment;

    }
}
