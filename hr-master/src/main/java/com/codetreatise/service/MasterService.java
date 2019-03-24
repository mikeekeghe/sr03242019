package com.codetreatise.service;

import com.codetreatise.bean.Items;
import com.codetreatise.generic.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MasterService extends GenericService<Items> {

    Page<Items> findAll(Pageable pageable);


    Items findByItemname(String itemname);
}
