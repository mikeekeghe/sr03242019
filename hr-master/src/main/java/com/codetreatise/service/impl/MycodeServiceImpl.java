package com.codetreatise.service.impl;

import com.codetreatise.bean.Mycode;
import com.codetreatise.repository.MycodeRepository;
import com.codetreatise.service.MycodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MycodeServiceImpl implements MycodeService {

    private final MycodeRepository mycodeRepository;

    @Autowired
    public MycodeServiceImpl(MycodeRepository mycodeRepository) {
        this.mycodeRepository = mycodeRepository;
    }

    @Override
    public Mycode save(Mycode entity) {
        return mycodeRepository.save(entity);
    }

    @Override
    public Mycode update(Mycode entity) {
        return mycodeRepository.save(entity);
    }

    @Override
    public void delete(Mycode entity) {
        mycodeRepository.delete(entity);
    }

    @Override
    public void delete(Long id) {
        mycodeRepository.delete(id);
    }

    @Override
    public List<Mycode> findAll() {
        return mycodeRepository.findAll();
    }

    @Override
    public void deleteInBatch(List<Mycode> mycodeList) {
        mycodeRepository.deleteInBatch(mycodeList);
    }

    @Override
    public Mycode find(Long id) {
        return mycodeRepository.findOne(id);
    }

    @Override
    public Mycode findByIcode(String icode) {
        return mycodeRepository.findByIcode(icode);
    }
}
