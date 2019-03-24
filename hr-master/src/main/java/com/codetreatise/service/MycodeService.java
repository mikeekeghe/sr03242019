package com.codetreatise.service;

import com.codetreatise.bean.Mycode;
import com.codetreatise.generic.GenericService;


public interface MycodeService extends GenericService<Mycode> {

    Mycode findByIcode(String icode);
}
