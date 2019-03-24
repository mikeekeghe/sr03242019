package com.codetreatise.service;

import com.codetreatise.bean.Customaccess;
import com.codetreatise.bean.Karigarmst;
import com.codetreatise.generic.GenericService;


public interface CustomaccessService extends GenericService<Customaccess> {

    Customaccess findByName(String name);
}
