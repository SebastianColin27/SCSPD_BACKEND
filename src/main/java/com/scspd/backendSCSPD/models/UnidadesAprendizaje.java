package com.scspd.backendSCSPD.models;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List; // <---- IMPORT LIST!
//MATERIAS
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("unidades_de_aprendizaje")
@JsonInclude(JsonInclude.Include.NON_NULL)// Nombre de la colección en MongoDB
public class UnidadesAprendizaje {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String nombreUnidadesDeAprendizaje;
    private String propositoUnidadesDeAprendizaje;
    private String unidadCompetencia;
    private List<Aprendizajes> aprendizajesEsperados;
    private Creditos creditos;
    private RelacionDirecta relacionDirecta;
    private List<Temas> temas;
    @Field("programa_academico_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId programaAcademicoId;
    @Field("unidad_academica_id")
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId unidadAcademicaId;

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Temas {
        private String temas;
        private String subtemas;
    }
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Aprendizajes {
        private String descripcion;

    }
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Creditos {
        private float tepic;
        private float sacta;
    }
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class RelacionDirecta{
        private String antecedentes;
        private String laterales;
        private String subsecuentes;
    }

}
