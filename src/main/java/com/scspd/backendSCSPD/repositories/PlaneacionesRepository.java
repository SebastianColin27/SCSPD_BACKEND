package com.scspd.backendSCSPD.repositories;

import com.scspd.backendSCSPD.models.Planeaciones;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneacionesRepository extends MongoRepository<Planeaciones, ObjectId>{
    // Método para filtrar por periodoEscolar
    List<Planeaciones> findByPeriodoEscolar(String periodoEscolar);
}
