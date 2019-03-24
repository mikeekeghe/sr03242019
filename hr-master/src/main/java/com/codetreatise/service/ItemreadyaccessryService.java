package com.codetreatise.service;

import com.codetreatise.bean.Itemkarigar;
import com.codetreatise.bean.Itemkarigaraccessry;
import com.codetreatise.bean.Itemready;
import com.codetreatise.bean.Itemreadyaccessry;
import com.codetreatise.generic.GenericService;


public interface ItemreadyaccessryService extends GenericService<Itemreadyaccessry> {


    Itemreadyaccessry findByItemready(Itemready itemready);
}
