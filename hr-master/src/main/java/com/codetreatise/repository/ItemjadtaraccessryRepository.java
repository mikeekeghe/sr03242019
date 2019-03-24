package com.codetreatise.repository;

import com.codetreatise.bean.Itemjadtar;
import com.codetreatise.bean.Itemjadtaraccessry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemjadtaraccessryRepository extends JpaRepository<Itemjadtaraccessry, Long> {

    Itemjadtaraccessry findByItemjadtar(Itemjadtar itemjadtar);
}
