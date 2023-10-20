package mx.metaphorce.blockbusterapips.repository;
import mx.metaphorce.blockbusterapips.model.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Integer>{
    
}
