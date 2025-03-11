package com.scspd.backendSCSPD.controllers;
import com.scspd.backendSCSPD.models.UnidadAcademica;
import com.scspd.backendSCSPD.services.UnidadAcademicaService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/unidadesAcademicas")
public class UnidadAcademicaController {
    @Autowired
    private UnidadAcademicaService unidadAcademicaService;

    @GetMapping
    public ResponseEntity<List<UnidadAcademica>> getAllUnidadesAcademicas() {
        return new ResponseEntity<>(unidadAcademicaService.getAllUnidadesAcademicas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UnidadAcademica>> getUnidadAcademicaById(@PathVariable ObjectId id) {
        Optional<UnidadAcademica> unidadAcademica = unidadAcademicaService.getUnidadAcademicaById(id);
        return unidadAcademica.map(response -> new ResponseEntity<>(Optional.of(response), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<UnidadAcademica> createUnidadAcademica(@RequestBody UnidadAcademica unidadAcademica) {
        return new ResponseEntity<>(unidadAcademicaService.createUnidadAcademica(unidadAcademica), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadAcademica> updateUnidadAcademica(@PathVariable ObjectId id, @RequestBody UnidadAcademica unidadAcademica) {
        if (unidadAcademicaService.getUnidadAcademicaById(id).isPresent()) {
            return new ResponseEntity<>(unidadAcademicaService.updateUnidadAcademica(id, unidadAcademica), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidadAcademica(@PathVariable ObjectId id) {
        if (unidadAcademicaService.getUnidadAcademicaById(id).isPresent()) {
            unidadAcademicaService.deleteUnidadAcademica(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
