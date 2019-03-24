package com.codetreatise.service.impl;

import com.codetreatise.bean.Karigarmst;
import com.codetreatise.bean.User;
import com.codetreatise.repository.KarigarmstRepository;
import com.codetreatise.service.KarigarmstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KarigarmstServiceImpl implements KarigarmstService {

	private final KarigarmstRepository karigarmstRepository;

	@Autowired
	public KarigarmstServiceImpl(KarigarmstRepository karigarmstRepository) {
		this.karigarmstRepository = karigarmstRepository;
	}

	@Override
	public Karigarmst save(Karigarmst entity) {
		return karigarmstRepository.save(entity);
	}

	@Override
	public Karigarmst update(Karigarmst entity) {
		return karigarmstRepository.save(entity);
	}

	@Override
	public void delete(Karigarmst entity) {
		karigarmstRepository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		karigarmstRepository.delete(id);
	}

	@Override
	public List<Karigarmst> findAll() {
		return karigarmstRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Karigarmst> karigarmstList) {
		karigarmstRepository.deleteInBatch(karigarmstList);
	}

	@Override
	public Karigarmst find(Long id) { return karigarmstRepository.findOne(id); }

	@Override
	public Karigarmst findByName(String name) {
		return karigarmstRepository.findByName(name);
	}

}
