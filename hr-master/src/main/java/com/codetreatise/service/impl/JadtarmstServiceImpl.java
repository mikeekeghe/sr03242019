package com.codetreatise.service.impl;

import com.codetreatise.bean.Jadtarmst;
import com.codetreatise.bean.User;
import com.codetreatise.repository.JadtarmstRepository;
import com.codetreatise.service.JadtarmstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JadtarmstServiceImpl implements JadtarmstService {

	private final JadtarmstRepository jadtarmstRepository;

	@Autowired
	public JadtarmstServiceImpl(JadtarmstRepository jadtarmstRepository) {
		this.jadtarmstRepository = jadtarmstRepository;
	}

	@Override
	public Jadtarmst save(Jadtarmst entity) {
		return jadtarmstRepository.save(entity);
	}

	@Override
	public Jadtarmst update(Jadtarmst entity) {
		return jadtarmstRepository.save(entity);
	}

	@Override
	public void delete(Jadtarmst entity) {
		jadtarmstRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		jadtarmstRepository.delete(id);
	}

	@Override
	public List<Jadtarmst> findAll() {
		return jadtarmstRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Jadtarmst> jadtarmstList) {
		jadtarmstRepository.deleteInBatch(jadtarmstList);
	}

	@Override
	public Jadtarmst find(Long id) { return jadtarmstRepository.findOne(id); }

	@Override
	public Jadtarmst findByName(String name) {
		return jadtarmstRepository.findByName(name);
	}
}
