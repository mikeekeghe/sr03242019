package com.codetreatise.service;

import com.codetreatise.bean.Karigarmst;
import com.codetreatise.bean.User;
import com.codetreatise.generic.GenericService;


public interface KarigarmstService extends GenericService<Karigarmst> {

    Karigarmst findByName(String name);
	
}
