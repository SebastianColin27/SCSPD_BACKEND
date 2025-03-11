package com.scspd.backendSCSPD.repositories;
import com.scspd.backendSCSPD.models.UnidadesAprendizaje;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadesAprendizajeRepository  extends MongoRepository<UnidadesAprendizaje, ObjectId> {
    List<UnidadesAprendizaje> findByProgramaAcademicoId(ObjectId programaAcademicoId);

}
