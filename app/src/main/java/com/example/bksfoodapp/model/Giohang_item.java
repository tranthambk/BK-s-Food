package com.example.bksfoodapp.model;

public class Giohang_item {
    public int id;
    public String tensp;
    public long giasp;
    public String hinhanhsanpham;
    public int soluongsp;

    public Giohang_item(int id, String tensp, long giasp, String hinhanhsanpham, int soluongsp) {
        this.id = id;
        this.tensp = tensp;
        this.giasp = giasp;
        this.hinhanhsanpham = hinhanhsanpham;
        this.soluongsp = soluongsp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public long getGiasp() {
        return giasp;
    }

    public void setGiasp(long giasp) {
        this.giasp = giasp;
    }

    public String getHinhanhsanpham() {
        return hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanhsanpham) {
        this.hinhanhsanpham = hinhanhsanpham;
    }

    public int getSoluongsp() {
        return soluongsp;
    }

    public void setSoluongsp(int soluongsp) {
        this.soluongsp = soluongsp;
    }
}
