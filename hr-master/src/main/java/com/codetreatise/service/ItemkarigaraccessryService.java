package com.codetreatise.service;

import com.codetreatise.bean.Itemkarigar;
import com.codetreatise.bean.Itemkarigaraccessry;
import com.codetreatise.generic.GenericService;


public interface ItemkarigaraccessryService extends GenericService<Itemkarigaraccessry> {


    Itemkarigaraccessry findByItemkarigar(Itemkarigar itemkarigar);
}
