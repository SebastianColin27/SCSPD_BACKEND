package com.scspd.backendSCSPD.repositories;
import com.scspd.backendSCSPD.models.ProgramasAcademicos;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramasAcademicosRepository extends MongoRepository<ProgramasAcademicos, ObjectId> {
}
