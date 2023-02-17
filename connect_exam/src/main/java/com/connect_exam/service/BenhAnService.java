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
    public void deleteBenhAn(Integer id) {
        iBenhAnRepository.deleteBenhAn(id);
    }


}
