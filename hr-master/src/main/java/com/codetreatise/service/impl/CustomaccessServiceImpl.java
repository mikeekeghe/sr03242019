package com.codetreatise.service.impl;

import com.codetreatise.bean.Customaccess;
import com.codetreatise.repository.CustomaccessRepository;
import com.codetreatise.service.CustomaccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomaccessServiceImpl implements CustomaccessService {

	private final CustomaccessRepository customaccessRepository;

	@Autowired
	public CustomaccessServiceImpl(CustomaccessRepository customaccessRepository) {
		this.customaccessRepository = customaccessRepository;
	}

	@Override
	public Customaccess save(Customaccess entity) {
		return customaccessRepository.save(entity);
	}

	@Override
	public Customaccess update(Customaccess entity) {
		return customaccessRepository.save(entity);
	}

	@Override
	public void delete(Customaccess entity) {
		customaccessRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		customaccessRepository.delete(id);
	}

	@Override
	public List<Customaccess> findAll() {
		return customaccessRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Customaccess> customaccessList) {
		customaccessRepository.deleteInBatch(customaccessList);
	}

	@Override
	public Customaccess find(Long id) { return customaccessRepository.findOne(id); }

	@Override
	public Customaccess findByName(String name) {
		return customaccessRepository.findByName(name);
	}

}
