package com.codetreatise.service.impl;

import com.codetreatise.bean.Items;
import com.codetreatise.repository.ItemsRepository;
import com.codetreatise.service.ItemsService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemsServiceImpl implements ItemsService {

    private final ItemsRepository itemsRepository;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    public ItemsServiceImpl(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @Override
    public Items save(Items entity) {
        return itemsRepository.save(entity);
    }

    @Override
    public Items update(Items entity) {
        return itemsRepository.save(entity);
    }

    @Override
    public void delete(Items entity) {
        itemsRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        itemsRepository.delete(id);
    }

    @Override
    public List<Items> findAll() {
        return itemsRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Items> items) {
        itemsRepository.deleteInBatch(items);
    }

    @Override
    public Items find(Long id) {
        return itemsRepository.findOne(id);
    }

    @Override
    public Page<Items> findAll(Pageable pageable) {
        return itemsRepository.findAll(pageable);
    }



}

