package com.codetreatise.service.impl;

import com.codetreatise.bean.Itemready;
import com.codetreatise.repository.ItemreadyRepository;
import com.codetreatise.service.ItemreadyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemreadyServiceImpl implements ItemreadyService {

    private final ItemreadyRepository itemreadyRepository;

    @Autowired
    public ItemreadyServiceImpl(ItemreadyRepository itemreadyRepository) {
        this.itemreadyRepository = itemreadyRepository;
    }

    @Override
    public Itemready save(Itemready entity) {
        return itemreadyRepository.save(entity);
    }

    @Override
    public Itemready update(Itemready entity) {
        return itemreadyRepository.save(entity);
    }

    @Override
    public void delete(Itemready entity) {
        itemreadyRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        itemreadyRepository.delete(id);
    }

    @Override
    public List<Itemready> findAll() {
        return itemreadyRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Itemready> itemreadyList) { itemreadyRepository.deleteInBatch(itemreadyList); }

    @Override
    public Itemready find(Long id) {
        return itemreadyRepository.findOne(id);
    }

}
