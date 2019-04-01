package com.codetreatise.service;

import com.codetreatise.bean.Items;
import com.codetreatise.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface MasterService extends GenericService<Items> {

    Page<Items> findAll(Pageable pageable);


    Items findByItemname(String itemname);

    List<Map<String, Object>> report(Long id);
}
