package com.connect_exam.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BenhNhan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String maBenhNhan;
    private String tenBenhNhan;
    @JsonBackReference
    @OneToMany(mappedBy = "benhNhan")
    Set<BenhAn> benhAn;

    public BenhNhan() {
    }

    public BenhNhan(int id, String maBenhNhan, String tenBenhNhan, Set<BenhAn> benhAn) {
        this.id = id;
        this.maBenhNhan = maBenhNhan;
        this.tenBenhNhan = tenBenhNhan;
        this.benhAn = benhAn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaBenhNhan() {
        return maBenhNhan;
    }

    public void setMaBenhNhan(String maBenhNhan) {
        this.maBenhNhan = maBenhNhan;
    }

    public String getTenBenhNhan() {
        return tenBenhNhan;
    }

    public void setTenBenhNhan(String tenBenhNhan) {
        this.tenBenhNhan = tenBenhNhan;
    }

    public Set<BenhAn> getBenhAn() {
        return benhAn;
    }

    public void setBenhAn(Set<BenhAn> benhAn) {
        this.benhAn = benhAn;
    }
}
