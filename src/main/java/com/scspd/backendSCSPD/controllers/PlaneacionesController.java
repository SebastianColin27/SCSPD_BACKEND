package com.scspd.backendSCSPD.controllers;
import com.scspd.backendSCSPD.models.Planeaciones;
import com.scspd.backendSCSPD.services.PlaneacionesService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planeaciones")
public class PlaneacionesController {
    @Autowired
    private PlaneacionesService planeacionesService;

    @GetMapping
    public ResponseEntity<List<Planeaciones>> getAllPlaneaciones() {
        return new ResponseEntity<>(planeacionesService.getAllPlaneaciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Planeaciones>> getPlaneacionesById(@PathVariable ObjectId id) {
        Optional<Planeaciones> planeacion = planeacionesService.getPlaneacionesById(id);
        return planeacion.map(response -> new ResponseEntity<>(Optional.of(response), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Planeaciones> createPlaneaciones(@RequestBody Planeaciones planeaciones) {
        return new ResponseEntity<>(planeacionesService.createPlaneaciones(planeaciones), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Planeaciones> updatePlaneaciones(@PathVariable ObjectId id, @RequestBody Planeaciones planeaciones) {
        if (planeacionesService.getPlaneacionesById(id).isPresent()) {
            return new ResponseEntity<>(planeacionesService.updatePlaneaciones(id, planeaciones), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaneaciones(@PathVariable ObjectId id) {
        if (planeacionesService.getPlaneacionesById(id).isPresent()) {
            planeacionesService.deletePlaneaciones(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/periodo")
    public List<Planeaciones> filtrarPorPeriodoEscolar(@RequestParam String periodoEscolar) {
        return planeacionesService.obtenerPorPeriodoEscolar(periodoEscolar);
    }
}
