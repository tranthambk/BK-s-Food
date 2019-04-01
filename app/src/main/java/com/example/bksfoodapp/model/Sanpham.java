package com.example.bksfoodapp.model;

import java.io.Serializable;

public class Sanpham implements Serializable {
    public int ID;
    public String Name;
    public int Price;
    public String Image;
    public String Des;

    public Sanpham(int ID, String name, int price, String image, String des) {
        this.ID = ID;
        this.Name = name;
        this.Price = price;
        this.Image = image;
        this.Des = des;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }
}
