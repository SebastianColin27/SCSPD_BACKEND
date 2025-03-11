package com.scspd.backendSCSPD.services;
import com.scspd.backendSCSPD.models.UnidadAcademica;
import com.scspd.backendSCSPD.repositories.UnidadAcademicaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadAcademicaService {
    @Autowired
    private UnidadAcademicaRepository unidadAcademicaRepository;

    public List<UnidadAcademica> getAllUnidadesAcademicas() {
        return unidadAcademicaRepository.findAll();
    }

    public Optional<UnidadAcademica> getUnidadAcademicaById(ObjectId id) {
        return unidadAcademicaRepository.findById(id);
    }

    public UnidadAcademica createUnidadAcademica(UnidadAcademica unidadAcademica) {
        return unidadAcademicaRepository.save(unidadAcademica);
    }

    public UnidadAcademica updateUnidadAcademica(ObjectId id, UnidadAcademica unidadAcademica) {
        unidadAcademica.setIdUnidadAcademica(id);
        return unidadAcademicaRepository.save(unidadAcademica);
    }

    public void deleteUnidadAcademica(ObjectId id) {
        unidadAcademicaRepository.deleteById(id);
    }
}
