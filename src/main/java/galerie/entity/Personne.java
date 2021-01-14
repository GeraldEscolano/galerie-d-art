/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import lombok.*;

/**
 *
 * @author escol
 */
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity // Une entité JPA
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private String nom;

    @Column(unique = true)
    @NonNull
    String adresse;

    @Column(unique = true)
    float budget;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clients")
    List<Transaction> achats;

    public float budgetArt(int annee) {
        float budget = 0f;
        for (Transaction t : this.achats) {
            Date d = t.getVenduLe();
            if (d.after(new Date(annee, 1, 1)) && d.before(new Date(annee, 12, 31))) {
                budget = t.getPrixVente() + budget;
            }
        }
        return budget;
    }
}
