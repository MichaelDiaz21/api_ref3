package co.edu.unab.api.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel , String> {
    
    ArrayList<ClienteModel> findByNombre (String nombre);
    @Query(value ="{'address.ciudad':?0,'address.departamento':?1}", fields = "{'nombre':1,'apellido':1}")
    ArrayList<ClienteModel> findByCiudad(String ciudad , String departamento);
    ArrayList<ClienteModel> findByPuntosGreaterThanEqual(long puntos);
    ArrayList<ClienteModel> findByPuntosLessThanEqual(long puntos);
    @Query(value ="{'apellido':?0,'nombre':?1}", fields = "{'id':1}")
    ArrayList<ClienteModel> findByApellido(String apellido,String nombre);

}

