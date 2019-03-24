package com.codetreatise.service;

import com.codetreatise.bean.Acntmst;
import com.codetreatise.bean.Customaccess;
import com.codetreatise.generic.GenericService;


public interface AcntmstService extends GenericService<Acntmst> {

    Acntmst findByName(String name);
}
