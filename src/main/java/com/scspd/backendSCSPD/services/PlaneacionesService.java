package com.scspd.backendSCSPD.services;
import com.scspd.backendSCSPD.models.Planeaciones;
import com.scspd.backendSCSPD.repositories.PlaneacionesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class PlaneacionesService {
    @Autowired
    private PlaneacionesRepository planeacionesRepository;

    public List<Planeaciones> getAllPlaneaciones() {
        return planeacionesRepository.findAll();
    }

    public Optional<Planeaciones> getPlaneacionesById(ObjectId id) {
        return planeacionesRepository.findById(id);
    }

    public Planeaciones createPlaneaciones(Planeaciones planeaciones) {
        return planeacionesRepository.save(planeaciones);
    }

    public Planeaciones updatePlaneaciones(ObjectId id, Planeaciones planeaciones) {
        planeaciones.setId(id);
        return planeacionesRepository.save(planeaciones);
    }

    public void deletePlaneaciones(ObjectId id) {
        planeacionesRepository.deleteById(id);
    }

    public List<Planeaciones> obtenerPorPeriodoEscolar(String periodoEscolar) {
        return planeacionesRepository.findByPeriodoEscolar(periodoEscolar);
    }
}
