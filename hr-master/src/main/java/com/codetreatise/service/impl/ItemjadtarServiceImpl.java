package com.codetreatise.service.impl;

import com.codetreatise.bean.Itemjadtar;
import com.codetreatise.repository.ItemjadtarRepository;
import com.codetreatise.service.ItemjadtarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemjadtarServiceImpl implements ItemjadtarService {

	private final ItemjadtarRepository itemjadtarRepository;

	@Autowired
	public ItemjadtarServiceImpl(ItemjadtarRepository itemjadtarRepository) {
		this.itemjadtarRepository = itemjadtarRepository;
	}

	@Override
	public Itemjadtar save(Itemjadtar entity) {
		return itemjadtarRepository.save(entity);
	}

	@Override
	public Itemjadtar update(Itemjadtar entity) {
		return itemjadtarRepository.save(entity);
	}

	@Override
	public void delete(Itemjadtar entity) {
		itemjadtarRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		itemjadtarRepository.delete(id);
	}

	@Override
	public List<Itemjadtar> findAll() {
		return itemjadtarRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Itemjadtar> itemjadtarList) {
		itemjadtarRepository.deleteInBatch(itemjadtarList);
	}

	@Override
	public Itemjadtar find(Long id) { return itemjadtarRepository.findOne(id); }

}
