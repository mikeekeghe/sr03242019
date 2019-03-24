package com.codetreatise.repository;

import com.codetreatise.bean.Karigarmst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KarigarmstRepository extends JpaRepository<Karigarmst, Long> {

    Karigarmst findByName(String name);

}
