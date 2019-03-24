package com.codetreatise.repository;

import com.codetreatise.bean.Itemkarigar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemkarigarRepository extends JpaRepository<Itemkarigar, Long> {


}
