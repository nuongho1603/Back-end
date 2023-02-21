package com.connect_exam.controller.rest;

import com.connect_exam.model.BenhAn;
import com.connect_exam.service.IBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class ViewBenhAnRestController {
    @Autowired
    private IBenhAnService iBenhAnService;
//
//    @GetMapping("/benhAn")
//    public ResponseEntity<List<BenhAn>> getAll() {
//        List<BenhAn> benhAnList = iBenhAnService.getAll();
//        if (benhAnList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(benhAnList, HttpStatus.OK);
//    }

    @GetMapping("/benhAn/page")
        public ResponseEntity<Page<BenhAn>> getPage(@PageableDefault(size = 2) Pageable pageable) {
        Page<BenhAn> benhAnList = iBenhAnService.getPageList(pageable);
        if (benhAnList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benhAnList, HttpStatus.OK);
    }

//    @GetMapping("/benhAn/search")
//    public ResponseEntity<Page<BenhAn>> searchByName(@RequestParam(name = "search",defaultValue = "") String search,@PageableDefault(size = 2) Pageable pageable) {
//        Page<BenhAn> benhAnPage = iBenhAnService.searchByName(search,pageable);
//        return new ResponseEntity<>(benhAnPage, HttpStatus.OK);
//    }

    @Modifying
    @DeleteMapping("/benhAn/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        iBenhAnService.deleteBenhAn(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/benhAn/{id}")
    public ResponseEntity<BenhAn> findById(@PathVariable int id) {
        BenhAn benhAn = iBenhAnService.findById(id);
        return new ResponseEntity<>(benhAn, HttpStatus.OK);
    }

    @PutMapping("/benhAn")
    public ResponseEntity<?> updateById(@RequestBody BenhAn benhAn) {
        iBenhAnService.update(benhAn.getMaBenhAn(), benhAn.getBenhNhan().getId(), benhAn.getNgayNhapVien(), benhAn.getNgayRaVien(), benhAn.getLyDo(), benhAn.getPhuongPhap(), benhAn.getBacSiDieuTri(), benhAn.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> addMedical(@RequestBody BenhAn benhAn) {
        iBenhAnService.add(benhAn.getMaBenhAn(), benhAn.getBenhNhan().getId(), benhAn.getNgayNhapVien(), benhAn.getNgayRaVien(), benhAn.getLyDo(), benhAn.getPhuongPhap(), benhAn.getBacSiDieuTri());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
