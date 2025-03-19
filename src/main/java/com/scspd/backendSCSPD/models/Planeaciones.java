package com.scspd.backendSCSPD.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.scspd.backendSCSPD.usuarios.Usuarios;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("planeaciones") // Nombre de la colección en MongoDB

public class Planeaciones {
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
   /* @DBRef(lazy = false)
    private Usuarios usuario;*/
    @DBRef(lazy = false)
    private UnidadAcademica unidadAcademica;
    @DBRef(lazy = false)
    private ProgramasAcademicos programaAcademico;
    @DBRef(lazy = false)
    private UnidadesAprendizaje unidadAprendizaje;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaCreacion;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaActualizacion;
    private String estado;

//1. DATOS GENERALES
    //1.1 unidad academica
    //1.2 programa academico
    //1.3 unidad de aprendizaje
    private int niveles;     //1.4
    private String areaFormacion; //1.5 área de formacion (opciones de select)
    private String modalidad; // 1.6 (opciones de select)
    private String tipoUnidadAprendizaje; // 1.7 (opc select)
    //1.8 creditos  from programa academico
    private String academia; //1.9 academia select
    private int semanasXsemestre; //1.10
    private List<SesionesSemestre> secionesXsemestre;//1.11
    private List<HorasSemestre> horasXemestre;//1.12
    private String periodoEscolar; //1.13 select
    private String grupo; // 1.14
    //1.15 nombre y firma from Usuario

//2. Relacion con otras materias y ejes
    //2.1.1/2/3 unidades con relacion directa from programa academico
    private String compromisoSocial; //2.2.1
    private String perspectivaGenero;//2.2.2
    private String internacionalizacionIPN;//2.2.3

//3. Organizacion didactica
    //3.1 materias from programa academico
    //3.2 proposito from programa academico
    private List<OrganizacionDidactica> organizacionDidactica;


//4. Referencias
    private List<Referencias> referencias;

//5. Herramientas para el plagio
private List<Herramientas> herramientas;


    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class  Actividades {
        private String descripcion;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Recursos {
        private String descripcion;

    }
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class SesionesSemestre {
        private int aula;
        private int laboratorio;
        private int clinica;
        private int otro;
        private int total;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class HorasSemestre {
        private float teoria;
        private float practica;
        private float totalTeoriaPractica;

        private float aula;
        private float laboratorio;
        private float clinica;
        private float otro;
        private float totalLugar;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class  Referencias{
        private String descripcion;

    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class Herramientas {
        private String descripcion;

    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class OrganizacionDidactica{

        private String estrategiaAprendizaje; //3.3 opciones de selct y modificables
        private String metodosEnsenanza; //3.4 opciones select y modificables
        private String unidadTematica;//3.5 select
        //3.6 relacionada a la materia
        private String periodoDesarrollo; //3.7
        private HorasSemestre horasXemestreXEspacio; //3.8
        private SesionesSemestre secionesXsemestreXeespacio;//3.9
        private String registroEvaluacion;//3.10
        private String aprendizajesEsperados;//3.11
        private int noSesion; //3.12 select
        //3.13 temas y subtemas
        private List<Actividades> descripcionActividades;//3.14
        private List<Recursos> recursosDidacticos;//3.15
        private String evidenciasAprendizaje;//3.16
        private float valorPorciento;//3.17
        private String instrumentosEvaluacion;//3.18
        private String presiosionesUnidad;//3.19
    }

}
