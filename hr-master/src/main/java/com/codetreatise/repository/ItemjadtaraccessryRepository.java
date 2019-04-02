package com.codetreatise.repository;

import com.codetreatise.bean.Itemjadtar;
import com.codetreatise.bean.Itemjadtaraccessry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemjadtaraccessryRepository extends JpaRepository<Itemjadtaraccessry, Long> {

    List<Itemjadtaraccessry> findByItemjadtar(Itemjadtar itemjadtar);
}
