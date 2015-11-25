package com.example.ubiinc.gifts.response;

/**
 * Created by ubiinc on 24/11/15.
 */
public class Product {
    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public String getPhoto() {

        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDetail() {

        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {

        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String get_id() {

        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    String _id;
    String name;
    String amount;
    String detail;
    String photo;
    String date_create;

}
