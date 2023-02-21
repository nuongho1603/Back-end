package com.connect_exam.repository;

import com.connect_exam.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;


import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@Repository
@Transactional
public interface IBenhAnRepository extends JpaRepository<BenhAn,Integer> {

    @Query(value = "select ba.* from `benh_an` ba", nativeQuery = true)
    List<BenhAn> getList();

    @Query(value = "select ba.* from `benh_an` ba", nativeQuery = true)
    Page<BenhAn> getPageList(Pageable pageable);
//
//    @Query(value = "select ba.* from `benh_an` ba where ba.ten_benh_an like concat('%',tenBenhAn,'%')", nativeQuery = true)
//    Page<BenhAn> searchByName(@RequestParam("tenBenhAn") String tenBenhAn, Pageable pageable);

    @Modifying
    @Query(value = "delete from benh_an where id = :id",nativeQuery = true)
        void deleteBenhAn(@Param("id") int id);

    @Query(value = "select ba.* from `benh_an` ba join `benh_nhan` bn on bn.id = ba.benh_nhan_id where  ba.id = :id",nativeQuery = true)
    BenhAn findById(@Param("id") int id);

    @Query(value = "INSERT INTO benh_an (ma_benh_an,benh_nhan_id,ngay_nhap_vien,ngay_ra_vien,ly_do, phuong_phap, bac_si_dieu_tri) VALUES (:maBenhAn, :benhNhan, :ngayNhapVien,:ngayRaVien,:lyDo,:phuongPhap,:bacSiDieuTri); ",nativeQuery = true)
    void add(@Param("maBenhAn") String maBenhAn,@Param("benhNhan") int benhNhan,@Param("ngayNhapVien") String ngayNhapVien,@Param("ngayRaVien") String ngayRaVien,@Param("lyDo") String lyDo,@Param("phuongPhap") String phuongPhap,@Param("bacSiDieuTri") String bacSiDieuTri);

    @Modifying
    @Query(value = "update benh_an set ma_benh_an = :maBenhAn, benh_nhan_id = :benhNhan, ngay_nhap_vien = :ngayNhapVien, ngay_ra_vien = :ngayRaVien, ly_do = :lyDo, phuong_phap = :phuongPhap, bac_si_dieu_tri = :bacSiDieuTri where id = :id",nativeQuery = true)
    void update(@Param("maBenhAn") String maBenhAn, @Param("benhNhan") int benhNhan, @Param("ngayNhapVien") String ngayNhapVien, @Param("ngayRaVien") String ngayRaVien, @Param("lyDo") String lyDo, @Param("phuongPhap") String phuongPhap, @Param("bacSiDieuTri") String bacSiDieuTri, @Param("id") int id);
}
