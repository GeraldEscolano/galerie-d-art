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
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity // Une entité JPA
public class Tableau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    @NonNull
    private String titre;

    @Column(unique = true)
    @NonNull
    private String support;

    @Column(unique = true)
    @NonNull
    private int largeur;

    @Column(unique = true)
    @NonNull
    private int hauteur;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "oeuvres")
    private List<Exposition> accrochages;

    @OneToOne(optional = true, mappedBy = "oeuvre")
    private Transaction vendu;

    @ManyToOne(optional = true)
    private Artiste auteur;

}
