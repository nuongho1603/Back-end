package com.connect_exam.service;

import com.connect_exam.model.BenhAn;
import com.connect_exam.repository.IBenhAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BenhAnService implements IBenhAnService{
    @Autowired
    private IBenhAnRepository iBenhAnRepository;

    @Override
    public List<BenhAn> getAll() {
        return iBenhAnRepository.getList();
    }

    @Override
    public void deleteBenhAn(int id) {
        iBenhAnRepository.deleteBenhAn(id);
    }

    @Override
    public BenhAn findById(int id) {
        return iBenhAnRepository.findById(id);
    }

    @Override
    public void update(String maBenhAn, int benhNhan, String ngayNhapVien, String ngayRaVien, String lyDo, String phuongPhap, String bacSiDieuTri, int id) {
        iBenhAnRepository.update(maBenhAn,benhNhan,ngayNhapVien,ngayRaVien,lyDo,phuongPhap,bacSiDieuTri,id);
    }

    @Override
    public void add(String maBenhAn, int benhNhan, String ngayNhapVien, String ngayRaVien, String lyDo, String phuongPhap, String bacSiDieuTri) {
        iBenhAnRepository.add(maBenhAn,benhNhan,ngayNhapVien,ngayRaVien,lyDo,phuongPhap,bacSiDieuTri);
    }


}
