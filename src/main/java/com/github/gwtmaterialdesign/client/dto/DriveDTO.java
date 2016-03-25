package com.github.gwtmaterialdesign.client.dto;

import gwt.material.design.client.constants.IconType;

public class DriveDTO {

    private IconType icon;
    private String fileName;
    private String ownerImage;
    private String owner;
    private String date;

    public DriveDTO() {}

    public DriveDTO(IconType icon, String fileName, String ownerImage, String owner, String date) {
        this.icon = icon;
        this.fileName = fileName;
        this.ownerImage = ownerImage;
        this.owner = owner;
        this.date = date;
    }

    public IconType getIcon() {
        return icon;
    }

    public void setIcon(IconType icon) {
        this.icon = icon;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOwnerImage() {
        return ownerImage;
    }

    public void setOwnerImage(String ownerImage) {
        this.ownerImage = ownerImage;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
