package com.micro.online.controller;

import com.micro.online.model.Scheme;
import com.micro.online.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/schemes")
public class SchemeController {

    @Autowired
    private SchemeService schemeService;

    @GetMapping
    public ResponseEntity<List<Scheme>> getAllSchemes() {
        List<Scheme> schemes = schemeService.getAllSchemes();
        return new ResponseEntity<>(schemes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scheme> getSchemeById(@PathVariable int id) {
        Optional<Scheme> scheme = schemeService.getSchemeById(id);
        return scheme.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Scheme> addScheme(@RequestBody Scheme scheme) {
        Scheme newScheme = schemeService.addScheme(scheme);
        return new ResponseEntity<>(newScheme, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Scheme> updateScheme(@PathVariable int id, @RequestBody Scheme scheme) {
        Scheme updatedScheme = schemeService.updateScheme(id, scheme);
        return updatedScheme != null ? ResponseEntity.ok(updatedScheme) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheme(@PathVariable int id) {
        schemeService.deleteScheme(id);
        return ResponseEntity.noContent().build();
    }
}
