package com.codetreatise.repository;

import com.codetreatise.bean.Itemkarigar;
import com.codetreatise.bean.Itemkarigaraccessry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemkarigaraccessryRepository extends JpaRepository<Itemkarigaraccessry, Long> {

    Itemkarigaraccessry findByItemkarigar(Itemkarigar itemkarigar);
}
