package com.codetreatise.service.impl;

import com.codetreatise.bean.Itemjadtar;
import com.codetreatise.bean.Itemjadtaraccessry;
import com.codetreatise.repository.ItemjadtaraccessryRepository;
import com.codetreatise.service.ItemjadtarcessryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemjadtaraccessryServiceImpl implements ItemjadtarcessryService {

    private final ItemjadtaraccessryRepository itemjadtaraccessryRepository;

    @Autowired
    public ItemjadtaraccessryServiceImpl(ItemjadtaraccessryRepository itemjadtaraccessryRepository) {
        this.itemjadtaraccessryRepository = itemjadtaraccessryRepository;
    }

    @Override
    public Itemjadtaraccessry save(Itemjadtaraccessry entity) {
        return itemjadtaraccessryRepository.save(entity);
    }

    @Override
    public Itemjadtaraccessry update(Itemjadtaraccessry entity) {
        return itemjadtaraccessryRepository.save(entity);
    }

    @Override
    public void delete(Itemjadtaraccessry entity) {
        itemjadtaraccessryRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        itemjadtaraccessryRepository.delete(id);
    }

    @Override
    public List<Itemjadtaraccessry> findAll() {
        return itemjadtaraccessryRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Itemjadtaraccessry> itemjadtaraccessryList) {
        itemjadtaraccessryRepository.deleteInBatch(itemjadtaraccessryList);
    }

    @Override
    public Itemjadtaraccessry find(Long id) {
        return itemjadtaraccessryRepository.findOne(id);
    }

    @Override
    public Itemjadtaraccessry findByItemjadtar(Itemjadtar itemjadtar) {
        return itemjadtaraccessryRepository.findByItemjadtar(itemjadtar);
    }

}
