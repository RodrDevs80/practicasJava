package com.app.rest.service.impl;

import com.app.rest.entities.Maker;
import com.app.rest.persistence.IMakerDAO;
import com.app.rest.service.IMakerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MakerService implements IMakerService {

    private IMakerDAO iMakerDAO;

    public MakerService(IMakerDAO iMakerDAO) {
        this.iMakerDAO = iMakerDAO;
    }

    @Override
    public List<Maker> findAll() {
        return iMakerDAO.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return iMakerDAO.findById(id);
    }

    @Override
    public void save(Maker maker) {
       iMakerDAO.save(maker);
    }

    @Override
    public void deleteById(Long id) {
      iMakerDAO.deleteById(id);
    }
}
