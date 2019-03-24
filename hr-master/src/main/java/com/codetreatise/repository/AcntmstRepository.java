package com.codetreatise.repository;

import com.codetreatise.bean.Acntmst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcntmstRepository extends JpaRepository<Acntmst, Long> {

    Acntmst findByName(String name);
}
