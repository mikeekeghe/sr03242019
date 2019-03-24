package com.codetreatise.repository;

import com.codetreatise.bean.Customaccess;
import com.codetreatise.bean.Karigarmst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomaccessRepository extends JpaRepository<Customaccess, Long> {
    Customaccess findByName(String name);

}
