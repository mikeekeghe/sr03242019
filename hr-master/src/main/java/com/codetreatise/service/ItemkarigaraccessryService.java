package com.codetreatise.service;

import com.codetreatise.bean.Itemkarigar;
import com.codetreatise.bean.Itemkarigaraccessry;
import com.codetreatise.generic.GenericService;

import java.util.List;


public interface ItemkarigaraccessryService extends GenericService<Itemkarigaraccessry> {


    List<Itemkarigaraccessry> findByItemkarigar(Itemkarigar itemkarigar);
}
