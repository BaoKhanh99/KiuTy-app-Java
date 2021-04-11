package com.example.kt_app;

import java.io.Serializable;

public class resultsearch implements Serializable {
    private static final long serialVersionUID = 1L;
    private int Id;
    private String destination;
    private String  infor;
    private String city;
    private int rating;
    private String img;
    private float point;
    private String comment;

    public resultsearch(int id, String destination, String infor, String city, int rating, String img, float point, String comment) {
        Id = id;
        this.destination = destination;
        this.infor = infor;
        this.city = city;
        this.rating = rating;
        this.img = img;
        this.point = point;
        this.comment = comment;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getInfor() {
        return infor;
    }

    public void setInfor(String infor) {
        this.infor = infor;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
