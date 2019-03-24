package com.codetreatise.service;

import com.codetreatise.bean.Jadtarmst;
import com.codetreatise.bean.Karigarmst;
import com.codetreatise.generic.GenericService;


public interface JadtarmstService extends GenericService<Jadtarmst> {

    Jadtarmst findByName(String name);
}
