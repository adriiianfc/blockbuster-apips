package mx.metaphorce.blockbusterapips.config;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mx.metaphorce.blockbusterapips.model.Usuario;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
 
    private String token;
    private String username;
    private List<String> roles;
    private Usuario user;
}