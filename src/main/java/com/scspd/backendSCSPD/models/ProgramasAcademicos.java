package com.scspd.backendSCSPD.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

// CARRERAS
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("programa_academico")

public class ProgramasAcademicos {
    @Id
    private ObjectId idProgramaAcademico;
    private String nombreProgramasAcademico;
    private String DescripcionProgramasAcademico;
    @DBRef
    private List<UnidadesAprendizaje> unidadesAprendizaje;
}
