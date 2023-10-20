package mx.metaphorce.blockbusterapips.repository;
import mx.metaphorce.blockbusterapips.model.Perfil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer>{
    
}
