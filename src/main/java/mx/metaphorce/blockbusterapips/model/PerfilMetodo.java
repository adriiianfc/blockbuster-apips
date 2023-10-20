package mx.metaphorce.blockbusterapips.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "perfilmetodos")
public class PerfilMetodo implements Serializable{
    @Id
    @Column(name = "id")
    private int id;
    
    
    @JoinColumn(name = "idmetodo")
    @OneToOne(fetch = FetchType.EAGER)
    private Metodo metodo;
    
    
}
