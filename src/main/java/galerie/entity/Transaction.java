/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author escol
 */
@Getter @Setter @NoArgsConstructor @RequiredArgsConstructor @ToString
@Entity // Une entité JPA
public class Transaction {
    
    @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
    
    @Column(unique=true)
    @NonNull
    private Date venduLe;
    
    @Column(unique=true)
    @NonNull
    private float prixVente;

    public Transaction(Integer id, Date venduLe, float prixVente) {
        this.id = id;
        this.venduLe = venduLe;
        this.prixVente = prixVente;
    }
    

}
