package com.codetreatise.repository;

import com.codetreatise.bean.Itemready;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemreadyRepository extends JpaRepository<Itemready, Long> {


}
