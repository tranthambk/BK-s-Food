package com.example.bksfoodapp.model;

public class List_view_menu {
    public int Id;
    public String Name;
    public String Image;

    public List_view_menu(int id, String name, String image) {
        Id = id;
        Name = name;
        Image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}
