/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import java.util.List;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author escol
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA 

public class Artiste extends Personne {
    
     @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    private String Biographie;
    
     @OneToMany(fetch = FetchType.LAZY, mappedBy = "Artiste")
    private List<Tableau> tableau;
}
