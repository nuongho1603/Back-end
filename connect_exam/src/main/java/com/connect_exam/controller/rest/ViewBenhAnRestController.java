package com.connect_exam.controller.rest;

import com.connect_exam.model.BenhAn;
import com.connect_exam.service.IBenhAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin("*")
public class ViewBenhAnRestController {
    @Autowired
    private IBenhAnService iBenhAnService;

    @GetMapping("/benhAn")
    public ResponseEntity<List<BenhAn>> getAll() {
        List<BenhAn> benhAnList = iBenhAnService.getAll();
        if (benhAnList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(benhAnList, HttpStatus.OK);
    }

    @DeleteMapping("/list/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        try {
            iBenhAnService.deleteBenhAn(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
