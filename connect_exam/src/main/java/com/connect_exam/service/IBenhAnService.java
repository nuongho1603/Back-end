package com.connect_exam.service;

import com.connect_exam.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface IBenhAnService {
    List<BenhAn> getAll();

    Page<BenhAn> getPageList(Pageable pageable);
//    Page<BenhAn> searchByName(String tenBenhAn,Pageable pageable);

    void deleteBenhAn(int id);

    BenhAn findById(int id);

    void update(String maBenhAn, int benhNhan, String ngayNhapVien, String ngayRaVien, String lyDo, String phuongPhap, String bacSiDieuTri, int id);

    void add(String maBenhAn, int benhNhan, String ngayNhapVien, String ngayRaVien, String lyDo, String phuongPhap, String bacSiDieuTri);

}
