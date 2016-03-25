package com.github.gwtmaterialdesign.client.dto;

import java.io.Serializable;

public class InboxLinkDTO implements Serializable {

    private String imgUser;
    private String name;
    private String title;
    private String description;
    private String linkImage;
    private String linkTitle;
    private String link;

    public InboxLinkDTO() {}

    public InboxLinkDTO(String imgUser, String name, String title, String description, String linkImage, String linkTitle, String link) {
        this.imgUser = imgUser;
        this.name = name;
        this.title = title;
        this.description = description;
        this.linkImage = linkImage;
        this.linkTitle = linkTitle;
        this.link = link;
    }

    public String getImgUser() {
        return imgUser;
    }

    public void setImgUser(String imgUser) {
        this.imgUser = imgUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
