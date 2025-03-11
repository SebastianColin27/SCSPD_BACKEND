package com.scspd.backendSCSPD.controllers;
import com.scspd.backendSCSPD.models.ProgramasAcademicos;
import com.scspd.backendSCSPD.services.ProgramasAcademicosService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/programasAcademicos")
public class ProgramasAcademicosController {
    @Autowired
    private ProgramasAcademicosService programasAcademicosService;

    @GetMapping
    public ResponseEntity<List<ProgramasAcademicos>> getAllProgramasAcademicos() {
        return new ResponseEntity<>(programasAcademicosService.getAllProgramasAcademicos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProgramasAcademicos>> getProgramasAcademicosById(@PathVariable ObjectId id) {
        Optional<ProgramasAcademicos> programaAcademico = programasAcademicosService.getProgramasAcademicosById(id);
        return programaAcademico.map(response -> new ResponseEntity<>(Optional.of(response), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProgramasAcademicos> createProgramasAcademicos(@RequestBody ProgramasAcademicos programasAcademicos) {
        return new ResponseEntity<>(programasAcademicosService.createProgramasAcademicos(programasAcademicos), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramasAcademicos> updateProgramasAcademicos(@PathVariable ObjectId id, @RequestBody ProgramasAcademicos programasAcademicos) {
        if (programasAcademicosService.getProgramasAcademicosById(id).isPresent()) {
            return new ResponseEntity<>(programasAcademicosService.updateProgramasAcademicos(id, programasAcademicos), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgramasAcademicos(@PathVariable ObjectId id) {
        if (programasAcademicosService.getProgramasAcademicosById(id).isPresent()) {
            programasAcademicosService.deleteProgramasAcademicos(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
