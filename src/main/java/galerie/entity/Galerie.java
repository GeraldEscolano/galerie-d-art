package galerie.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import lombok.*;

// Un exemple d'entité
// On utilise Lombok pour auto-générer getter / setter / toString...
// cf. https://examples.javacodegeeks.com/spring-boot-with-lombok/
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity // Une entité JPA
public class Galerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "galerie_id")
    private Integer id;

    @Column(unique = true)
    @NonNull
    private String nom;

    @Column(unique = true)
    @NonNull
    private String adresse;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "Galerie")
    private List<Exposition> expos;

    public Galerie(Integer id, String nom, String adresse, List<Exposition> expos) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        expos = new ArrayList<Exposition>();
    }

    
    public float CAannuel(int a) {
        float ca_annuel = 0;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        Date d;
        try {
            d = formatter.parse(String.valueOf(a));
            for (Exposition e : expos) {
                if (d.equals(e.getDate())) {
                    ca_annuel = e.Ca() + ca_annuel;

                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(Galerie.class.getName()).log(Level.SEVERE, null, ex);
        }
       return ca_annuel;
    }
    
    
}
