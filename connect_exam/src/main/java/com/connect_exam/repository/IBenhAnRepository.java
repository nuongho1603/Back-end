package com.connect_exam.repository;

import com.connect_exam.model.BenhAn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IBenhAnRepository extends JpaRepository<BenhAn,Integer> {

    @Query(value = "select ba.* from `benh_an` ba;", nativeQuery = true)
    List<BenhAn> getList();


    @Query(value = "delete from benh_an where id = :id;",nativeQuery = true)
        void deleteBenhAn(@Param("id") Integer id);
}
