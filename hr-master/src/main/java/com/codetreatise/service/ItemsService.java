package com.codetreatise.service;

import com.codetreatise.bean.Items;
import com.codetreatise.generic.GenericService;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;


public interface ItemsService extends GenericService<Items> {

    Page<Items> findAll(Pageable pageable);


}
