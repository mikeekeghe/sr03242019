package com.codetreatise.service.impl;

import com.codetreatise.bean.Itemready;
import com.codetreatise.bean.Itemreadyaccessry;
import com.codetreatise.repository.ItemreadyaccessryRepository;
import com.codetreatise.service.ItemreadyaccessryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemreadyaccessryServiceImpl implements ItemreadyaccessryService {

    private final ItemreadyaccessryRepository itemreadyaccessryRepository;

    @Autowired
    public ItemreadyaccessryServiceImpl(ItemreadyaccessryRepository itemreadyaccessryRepository) {
        this.itemreadyaccessryRepository = itemreadyaccessryRepository;
    }

    @Override
    public Itemreadyaccessry save(Itemreadyaccessry entity) {
        return itemreadyaccessryRepository.save(entity);
    }

    @Override
    public Itemreadyaccessry update(Itemreadyaccessry entity) {
        return itemreadyaccessryRepository.save(entity);
    }

    @Override
    public void delete(Itemreadyaccessry entity) {
        itemreadyaccessryRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        itemreadyaccessryRepository.delete(id);
    }

    @Override
    public List<Itemreadyaccessry> findAll() {
        return itemreadyaccessryRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Itemreadyaccessry> itemreadyaccessryList) {
        itemreadyaccessryRepository.deleteInBatch(itemreadyaccessryList);
    }

    @Override
    public Itemreadyaccessry find(Long id) {
        return itemreadyaccessryRepository.findOne(id);
    }

    @Override
    public Itemreadyaccessry findByItemready(Itemready itemready) {
        return itemreadyaccessryRepository.findByItemready(itemready);
    }

}
