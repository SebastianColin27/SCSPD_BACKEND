package com.scspd.backendSCSPD.services;
import com.scspd.backendSCSPD.models.UnidadesAprendizaje;
import com.scspd.backendSCSPD.repositories.UnidadesAprendizajeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadesAprendizajeService {
    @Autowired
    private UnidadesAprendizajeRepository unidadesAprendizajeRepository;

    public List<UnidadesAprendizaje> getAllUnidadesAprendizaje() {
        return unidadesAprendizajeRepository.findAll();
    }

    public Optional<UnidadesAprendizaje> getUnidadesAprendizajeById(ObjectId id) {
        return unidadesAprendizajeRepository.findById(id);
    }

    public UnidadesAprendizaje createUnidadesAprendizaje(UnidadesAprendizaje unidadesAprendizaje) {
        return unidadesAprendizajeRepository.save(unidadesAprendizaje);
    }

    public UnidadesAprendizaje updateUnidadesAprendizaje(ObjectId id, UnidadesAprendizaje unidadesAprendizaje) {
        unidadesAprendizaje.setIdUnidadesDeAprendizaje(id);
        return unidadesAprendizajeRepository.save(unidadesAprendizaje);
    }

    public void deleteUnidadesAprendizaje(ObjectId id) {
        unidadesAprendizajeRepository.deleteById(id);
    }

    public List<UnidadesAprendizaje> getUnidadesAprendizajeByProgramaAcademico(ObjectId programaAcademicoId) {
        return unidadesAprendizajeRepository.findByProgramaAcademicoId(programaAcademicoId);
    }

}
