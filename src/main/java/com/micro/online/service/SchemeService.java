package com.micro.online.service;

import com.micro.online.model.Scheme;
import java.util.List;
import java.util.Optional;

public interface SchemeService {
    List<Scheme> getAllSchemes();
    Optional<Scheme> getSchemeById(int id);
    Scheme addScheme(Scheme scheme);
    Scheme updateScheme(int id, Scheme scheme);
    void deleteScheme(int id);
}
