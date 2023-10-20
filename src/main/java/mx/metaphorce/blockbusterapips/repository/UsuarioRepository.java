package mx.metaphorce.blockbusterapips.repository;
import mx.metaphorce.blockbusterapips.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    @Query("SELECT u FROM Usuario u WHERE u.usuario = ?1 ")
    public Usuario login(String username);
}
