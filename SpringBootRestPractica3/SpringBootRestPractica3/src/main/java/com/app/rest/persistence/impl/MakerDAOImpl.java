package com.app.rest.persistence.impl;

import com.app.rest.entities.Maker;
import com.app.rest.persistence.IMakerDAO;
import com.app.rest.repository.MakerRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
public class MakerDAOImpl implements IMakerDAO {

    private MakerRepository makerRepository;

    public MakerDAOImpl(MakerRepository makerRepository) {
        this.makerRepository = makerRepository;
    }

    @Override
    public List<Maker> findAll() {
      return (List<Maker>) makerRepository.findAll();
    }

    @Override
    public Optional<Maker> findById(Long id) {
        return makerRepository.findById(id);
    }

    @Override
    public void save(Maker maker) {
       makerRepository.save(maker);
    }

    @Override
    public void deleteById(Long id) {
       makerRepository.deleteById(id);
    }
}
