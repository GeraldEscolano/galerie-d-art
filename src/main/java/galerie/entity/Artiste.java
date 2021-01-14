package galerie.entity;

import java.util.List;
import javax.persistence.Entity;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity // Une entité JPA
public class Artiste extends Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String Biographie;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "auteur")
    private List<Tableau> oeuvres;
}
