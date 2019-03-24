package com.codetreatise.repository;

import com.codetreatise.bean.Items;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterRepository extends JpaRepository<Items, Long>, QueryDslPredicateExecutor<Items> {

    Page<Items> findAll(Pageable pageable);

    Page<Items> findAll(Predicate predicate, Pageable pageable);

    Items findByItemname(String itemname);

}
