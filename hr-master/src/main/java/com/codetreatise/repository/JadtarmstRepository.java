package com.codetreatise.repository;

import com.codetreatise.bean.Jadtarmst;
import com.codetreatise.bean.Karigarmst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JadtarmstRepository extends JpaRepository<Jadtarmst, Long> {

    Jadtarmst findByName(String name);
}
