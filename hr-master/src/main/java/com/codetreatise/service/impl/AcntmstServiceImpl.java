package com.codetreatise.service.impl;

import com.codetreatise.bean.Acntmst;
import com.codetreatise.repository.AcntmstRepository;
import com.codetreatise.service.AcntmstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcntmstServiceImpl implements AcntmstService {

	private final AcntmstRepository acntmstRepository;

	@Autowired
	public AcntmstServiceImpl(AcntmstRepository acntmstRepository) {
		this.acntmstRepository = acntmstRepository;
	}

	@Override
	public Acntmst save(Acntmst entity) {
		return acntmstRepository.save(entity);
	}

	@Override
	public Acntmst update(Acntmst entity) {
		return acntmstRepository.save(entity);
	}

	@Override
	public void delete(Acntmst entity) {
		acntmstRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		acntmstRepository.delete(id);
	}

	@Override
	public List<Acntmst> findAll() {
		return acntmstRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Acntmst> acntmstList) {
		acntmstRepository.deleteInBatch(acntmstList);
	}

	@Override
	public Acntmst find(Long id) { return acntmstRepository.findOne(id); }

	@Override
	public Acntmst findByName(String name) {
		return acntmstRepository.findByName(name);
	}
}
