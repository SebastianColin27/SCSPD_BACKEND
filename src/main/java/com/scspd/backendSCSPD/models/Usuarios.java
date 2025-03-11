package com.scspd.backendSCSPD.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import java.util.List; // <---- IMPORT LIST!

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("usuarios") // Nombre de la colección en MongoDB
public class Usuarios {
    @Id
    private ObjectId idDocentes;
    private String nombre;
    private String correo;
    private String password;

    private List<String> roles;

}
