package com.scspd.backendSCSPD.services;
import com.scspd.backendSCSPD.models.ProgramasAcademicos;
import com.scspd.backendSCSPD.repositories.ProgramasAcademicosRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramasAcademicosService {
    @Autowired
    private ProgramasAcademicosRepository programasAcademicosRepository;

    public List<ProgramasAcademicos> getAllProgramasAcademicos() {
        return programasAcademicosRepository.findAll();
    }

    public Optional<ProgramasAcademicos> getProgramasAcademicosById(ObjectId id) {
        return programasAcademicosRepository.findById(id);
    }

    public ProgramasAcademicos createProgramasAcademicos(ProgramasAcademicos programasAcademicos) {
        return programasAcademicosRepository.save(programasAcademicos);
    }

    public ProgramasAcademicos updateProgramasAcademicos(ObjectId id, ProgramasAcademicos programasAcademicos) {
        programasAcademicos.setId(id);
        return programasAcademicosRepository.save(programasAcademicos);
    }

    public void deleteProgramasAcademicos(ObjectId id) {
        programasAcademicosRepository.deleteById(id);
    }
}
