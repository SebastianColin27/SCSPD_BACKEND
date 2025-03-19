package com.scspd.backendSCSPD.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProgramasAcademicos {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String nombreProgramasAcademico;
    private String descripcionProgramasAcademico;
  /*  @DBRef
    private List<UnidadesAprendizaje> unidadesAprendizaje;*/
}
