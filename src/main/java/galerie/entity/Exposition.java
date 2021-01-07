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
public class Exposition {
     @Id  @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;
     
    @Column(unique=true)
    @NonNull
    private Date date;
    
    @Column(unique=true)
    @NonNull
    private String intitule;
    
    @Column(unique=true)
    @NonNull
    private int duree;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Exposition")
    private List<Transaction> transactions;
    
    @NonNull
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "Exposition")
    private List<Tableau> tableaux;

    public Exposition(Integer id, Date date, String intitule, int duree, List<Transaction> transactions, List<Tableau> tableaux) {
        this.id = id;
        this.date = date;
        this.intitule = intitule;
        this.duree = duree;
        this.transactions = transactions;
        this.tableaux = tableaux;
    }
        
    
    
    public float Ca(){
    float ca = 0;
     for (Transaction t : this.transactions){
       ca = ca + t.getPrixVente();
     }   
     return ca;
    }
   
    }
