package com.example.ubiinc.gifts.list;

/**
 * Created by ubiinc on 24/11/15.
 */
public class Item {

    private String image;
    private String title;
    private String description;

    public Item() {
        super();
    }

    public Item(String image, String title, String description) {
        super();
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
