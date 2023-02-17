package com.connect_exam.service;

import com.connect_exam.model.BenhAn;

import java.util.List;

public interface IBenhAnService {
List<BenhAn> getAll();

void deleteBenhAn(Integer id);
}
