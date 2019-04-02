package com.codetreatise.service;

import com.codetreatise.bean.Itemjadtar;
import com.codetreatise.bean.Itemjadtaraccessry;
import com.codetreatise.generic.GenericService;

import java.util.List;


public interface ItemjadtarcessryService extends GenericService<Itemjadtaraccessry> {


    List<Itemjadtaraccessry> findByItemjadtar(Itemjadtar itemjadtar);
}
