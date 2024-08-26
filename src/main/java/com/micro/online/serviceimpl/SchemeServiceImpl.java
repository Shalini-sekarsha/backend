package com.micro.online.serviceimpl;

import com.micro.online.model.Scheme;
import com.micro.online.repository.SchemeRepository;
import com.micro.online.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchemeServiceImpl implements SchemeService {

    @Autowired
    private SchemeRepository schemeRepository;

    @Override
    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }

    @Override
    public Optional<Scheme> getSchemeById(int id) {
        return schemeRepository.findById(id);
    }

    @Override
    public Scheme addScheme(Scheme scheme) {
        return schemeRepository.save(scheme);
    }

    @Override
    public Scheme updateScheme(int id, Scheme scheme) {
        if (schemeRepository.existsById(id)) {
            scheme.setSchemeID(id);
            return schemeRepository.save(scheme);
        } else {
            // You might want to handle this case differently
            return null;
        }
    }

    @Override
    public void deleteScheme(int id) {
        if (schemeRepository.existsById(id)) {
            schemeRepository.deleteById(id);
        }
    }
}
