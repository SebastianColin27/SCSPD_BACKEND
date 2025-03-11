package com.scspd.backendSCSPD.models;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import org.bson.types.ObjectId;
import java.util.List; // <---- IMPORT LIST!
//MATERIAS
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("unidades_de_aprendizaje") // Nombre de la colección en MongoDB
public class UnidadesAprendizaje {
    @Id
    private ObjectId idUnidadesDeAprendizaje;
    private String nombreUnidadesDeAprendizaje;
    private String propositoUnidadesDeAprendizaje;
    private String unidadCompetencia;
    private List<Aprendizajes> aprendizajesEsperados;
    private Creditos creditos;
    private RelacionDirecta relacionDirecta;
    private List<Temas> temas;

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
