package com.codetreatise.repository;

import com.codetreatise.bean.Itemkarigar;
import com.codetreatise.bean.Itemkarigaraccessry;
import com.codetreatise.bean.Itemready;
import com.codetreatise.bean.Itemreadyaccessry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemreadyaccessryRepository extends JpaRepository<Itemreadyaccessry, Long> {

    List<Itemreadyaccessry> findByItemready(Itemready itemready);
}
