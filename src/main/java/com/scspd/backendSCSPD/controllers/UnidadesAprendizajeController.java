package com.scspd.backendSCSPD.controllers;

import com.scspd.backendSCSPD.models.UnidadesAprendizaje;
import com.scspd.backendSCSPD.services.UnidadesAprendizajeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/unidadesAprendizaje")
public class UnidadesAprendizajeController {
    @Autowired
    private UnidadesAprendizajeService unidadesAprendizajeService;

    @GetMapping
    public ResponseEntity<List<UnidadesAprendizaje>> getAllUnidadesAprendizaje() {
        return new ResponseEntity<>(unidadesAprendizajeService.getAllUnidadesAprendizaje(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UnidadesAprendizaje>> getUnidadesAprendizajeById(@PathVariable ObjectId id) {
        Optional<UnidadesAprendizaje> unidad = unidadesAprendizajeService.getUnidadesAprendizajeById(id);
        return unidad.map(response -> new ResponseEntity<>(Optional.of(response), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<UnidadesAprendizaje> createUnidadesAprendizaje(@RequestBody UnidadesAprendizaje unidadesAprendizaje) {
        return new ResponseEntity<>(unidadesAprendizajeService.createUnidadesAprendizaje(unidadesAprendizaje), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnidadesAprendizaje> updateUnidadesAprendizaje(@PathVariable ObjectId id, @RequestBody UnidadesAprendizaje unidadesAprendizaje) {
        if (unidadesAprendizajeService.getUnidadesAprendizajeById(id).isPresent()) {
            return new ResponseEntity<>(unidadesAprendizajeService.updateUnidadesAprendizaje(id, unidadesAprendizaje), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnidadesAprendizaje(@PathVariable ObjectId id) {
        if (unidadesAprendizajeService.getUnidadesAprendizajeById(id).isPresent()) {
            unidadesAprendizajeService.deleteUnidadesAprendizaje(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/programa/{programaAcademicoId}")
    public ResponseEntity<List<UnidadesAprendizaje>> getUnidadesAprendizajeByProgramaAcademico(
            @PathVariable ObjectId programaAcademicoId) {
        List<UnidadesAprendizaje> unidades = unidadesAprendizajeService.getUnidadesAprendizajeByProgramaAcademico(programaAcademicoId);
        return new ResponseEntity<>(unidades, HttpStatus.OK);
    }


    @GetMapping("/unidad/{unidadAcademicaId}")
    public ResponseEntity<List<UnidadesAprendizaje>> getUnidadesAprendizajeByUnidadAcademica(
            @PathVariable ObjectId unidadAcademicaId) {
        List<UnidadesAprendizaje> unidades = unidadesAprendizajeService.obtenerPorUnidadAcademica(unidadAcademicaId);
        return new ResponseEntity<>(unidades, HttpStatus.OK);
    }

}
