package com.scspd.backendSCSPD.usuarios;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.*;
import org.springframework.data.annotation.Id;
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
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;
    private String nombre;
    private String correo;
    private String password;


    private List<Role> roles;
}
