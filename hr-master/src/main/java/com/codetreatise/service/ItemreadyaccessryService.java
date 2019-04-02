package com.codetreatise.service;

import com.codetreatise.bean.Itemready;
import com.codetreatise.bean.Itemreadyaccessry;
import com.codetreatise.generic.GenericService;

import java.util.List;


public interface ItemreadyaccessryService extends GenericService<Itemreadyaccessry> {


    List<Itemreadyaccessry> findByItemready(Itemready itemready);
}
