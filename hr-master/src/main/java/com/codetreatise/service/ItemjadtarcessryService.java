package com.codetreatise.service;

import com.codetreatise.bean.Itemjadtar;
import com.codetreatise.bean.Itemjadtaraccessry;
import com.codetreatise.generic.GenericService;


public interface ItemjadtarcessryService extends GenericService<Itemjadtaraccessry> {


    Itemjadtaraccessry findByItemjadtar(Itemjadtar itemjadtar);
}
