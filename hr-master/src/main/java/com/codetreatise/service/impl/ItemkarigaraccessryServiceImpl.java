package com.codetreatise.service.impl;

import com.codetreatise.bean.Itemkarigar;
import com.codetreatise.bean.Itemkarigaraccessry;
import com.codetreatise.repository.ItemkarigaraccessryRepository;
import com.codetreatise.service.ItemkarigaraccessryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemkarigaraccessryServiceImpl implements ItemkarigaraccessryService {

    private final ItemkarigaraccessryRepository itemkarigaraccessryRepository;

    @Autowired
    public ItemkarigaraccessryServiceImpl(ItemkarigaraccessryRepository itemkarigaraccessryRepository) {
        this.itemkarigaraccessryRepository = itemkarigaraccessryRepository;
    }

    @Override
    public Itemkarigaraccessry save(Itemkarigaraccessry entity) {
        return itemkarigaraccessryRepository.save(entity);
    }

    @Override
    public Itemkarigaraccessry update(Itemkarigaraccessry entity) {
        return itemkarigaraccessryRepository.save(entity);
    }

    @Override
    public void delete(Itemkarigaraccessry entity) {
        itemkarigaraccessryRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        itemkarigaraccessryRepository.delete(id);
    }

    @Override
    public List<Itemkarigaraccessry> findAll() {
        return itemkarigaraccessryRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Itemkarigaraccessry> itemkarigarList) {
        itemkarigaraccessryRepository.deleteInBatch(itemkarigarList);
    }

    @Override
    public Itemkarigaraccessry find(Long id) {
        return itemkarigaraccessryRepository.findOne(id);
    }

    @Override
    public List<Itemkarigaraccessry> findByItemkarigar(Itemkarigar itemkarigar) {
        return itemkarigaraccessryRepository.findByItemkarigar(itemkarigar);
    }

}
