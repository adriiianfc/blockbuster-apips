package mx.metaphorce.blockbusterapips.controller;

import java.util.List;
import mx.metaphorce.blockbusterapips.model.Actor;
import mx.metaphorce.blockbusterapips.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actores")
public class ActorController {
    
    @Autowired
    ActorService ser;
    
    @PostMapping("/add")
    public void add(@RequestBody Actor body){
        ser.add(body);
    }
    
    @GetMapping("/getAll")
    public List<Actor> getAll(){
        return ser.getAll();
    }
    
    @GetMapping("/getActor")
    public Actor getActor(@RequestParam String id){
        return ser.getActor(id).get();
    }
}
