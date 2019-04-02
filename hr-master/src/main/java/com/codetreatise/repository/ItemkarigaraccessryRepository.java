package com.codetreatise.repository;

import com.codetreatise.bean.Itemkarigar;
import com.codetreatise.bean.Itemkarigaraccessry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemkarigaraccessryRepository extends JpaRepository<Itemkarigaraccessry, Long> {

    List<Itemkarigaraccessry> findByItemkarigar(Itemkarigar itemkarigar);
}
