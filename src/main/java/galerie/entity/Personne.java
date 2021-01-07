/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;

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
    String[] adresse;

    @Column(unique = true)
    float budget;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Personne")
    List<Transaction> transactions;

    public Personne(Integer id, String nom, float budget, String[] adresse, List<Transaction> transactions) {
        this.id = id;
        this.nom = nom;
        this.budget = budget;
        adresse = new String[]{};
        transactions = new LinkedList<Transaction>();
    }

    public Personne(Integer id, String nom, String[] adresse) {
        this.id = id;
        this.nom = nom;

        adresse = new String[]{};

    }

    public float budgetArt(int annee) {
        throw new UnsupportedOperationException("Pas encore implémenté");
    }

}
