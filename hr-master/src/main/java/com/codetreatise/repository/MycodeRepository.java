package com.codetreatise.repository;

import com.codetreatise.bean.Mycode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MycodeRepository extends JpaRepository<Mycode, Long> {

    Mycode findByIcode(String icode);
}
