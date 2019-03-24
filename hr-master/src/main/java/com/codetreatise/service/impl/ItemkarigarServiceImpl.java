package com.codetreatise.service.impl;

import com.codetreatise.bean.Itemkarigar;
import com.codetreatise.repository.ItemkarigarRepository;
import com.codetreatise.service.ItemkarigarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemkarigarServiceImpl implements ItemkarigarService {

	private final ItemkarigarRepository itemkarigarRepository;

	@Autowired
	public ItemkarigarServiceImpl(ItemkarigarRepository itemkarigarRepository) {
		this.itemkarigarRepository = itemkarigarRepository;
	}

	@Override
	public Itemkarigar save(Itemkarigar entity) {
		return itemkarigarRepository.save(entity);
	}

	@Override
	public Itemkarigar update(Itemkarigar entity) {
		return itemkarigarRepository.save(entity);
	}

	@Override
	public void delete(Itemkarigar entity) {
		itemkarigarRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		itemkarigarRepository.delete(id);
	}

	@Override
	public List<Itemkarigar> findAll() {
		return itemkarigarRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Itemkarigar> itemkarigarList) {
		itemkarigarRepository.deleteInBatch(itemkarigarList);
	}

	@Override
	public Itemkarigar find(Long id) { return itemkarigarRepository.findOne(id); }

}
