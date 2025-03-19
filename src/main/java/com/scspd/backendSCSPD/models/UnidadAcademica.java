package com.scspd.backendSCSPD.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UnidadAcademica {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String nombreUnidadAcademca;
  /*  @DBRef
    private ProgramasAcademicos programasAcademico;
    @DBRef
    private UnidadesAprendizaje unidadesAprendizaje;*/
}