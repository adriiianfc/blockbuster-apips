package mx.metaphorce.blockbusterapips.service;

import java.util.ArrayList;
import java.util.List;
import mx.metaphorce.blockbusterapips.model.Usuario;
import mx.metaphorce.blockbusterapips.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository repo;
    
    public List<Usuario> getAll(){
        List<Usuario> usuarios = new ArrayList<>();
        for(Usuario usuario : repo.findAll()){
            usuarios.add(usuario);
        }
        return usuarios;
    }
    
    public void add(Usuario usuario){
        repo.save(usuario);
    }
    
    public Usuario login(String username){
        return repo.login(username);
    }
}
