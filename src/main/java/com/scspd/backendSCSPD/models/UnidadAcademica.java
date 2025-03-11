package com.scspd.backendSCSPD.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
//PROGRAMA ACADEMICO = CARREA
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("unidad_academica") // Nombre de la colección en MongoDB
public class UnidadAcademica {
    @Id
    private ObjectId idUnidadAcademica;
    private String nombreUnidadAcademca;
    @DBRef
    private ProgramasAcademicos programasAcademico;
    @DBRef
    private UnidadesAprendizaje unidadesAprendizaje;
}