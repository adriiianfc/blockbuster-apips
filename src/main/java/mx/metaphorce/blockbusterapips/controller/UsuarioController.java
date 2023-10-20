package mx.metaphorce.blockbusterapips.controller;

import java.util.List;
import java.util.stream.Collectors;
import mx.metaphorce.blockbusterapips.config.JwtResponse;
import mx.metaphorce.blockbusterapips.config.JwtUtils;
import mx.metaphorce.blockbusterapips.domain.UserDTO;
import mx.metaphorce.blockbusterapips.model.Usuario;
import mx.metaphorce.blockbusterapips.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService ser;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/add")
    public void add(@RequestBody Usuario body) {
        ser.add(body);
    }

    @GetMapping("/getAll")
    public List<Usuario> getAll() {
        return ser.getAll();
    }

    @PostMapping("/token")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDTO userDTO) {
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getUsuario(), 
                        //"{bcrypt}"+bcrypt.encode(userDTO.getPassword())));
                       userDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication, ser.login(userDTO.getUsuario()));

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getUsername(),
                roles,jwtUtils.getUserData(jwt)));
    }
}
