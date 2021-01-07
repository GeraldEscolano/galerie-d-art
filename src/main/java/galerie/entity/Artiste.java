/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.util.ArrayList;
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
    
    @Column(unique=true)
    private String Biographie;
    
     @OneToMany(fetch = FetchType.LAZY, mappedBy = "Artiste")
    private List<Tableau> tableau;

    public Artiste(Integer id, String Biographie, List<Tableau> tableau, Integer id, String nom, String[] adresse, List<Transaction> transactions) {
        super(id, nom, adresse, transactions);
        this.Biographie = Biographie;
        tableau = new ArrayList<Tableau>();
    }

    
    
     
}
