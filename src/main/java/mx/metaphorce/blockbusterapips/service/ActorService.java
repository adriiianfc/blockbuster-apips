package mx.metaphorce.blockbusterapips.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mx.metaphorce.blockbusterapips.model.Actor;
import mx.metaphorce.blockbusterapips.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {
    @Autowired
    ActorRepository repo;
    
    public List<Actor> getAll(){
        List<Actor> actores = new ArrayList<>();
        for(Actor actor : repo.findAll()){
            actores.add(actor);
        }
        return actores;
    }
    
    public void add(Actor actor){
        repo.save(actor);
    }
    
    public Optional<Actor> getActor(String id){
        return repo.findById(Integer.valueOf(id));
    }
}
