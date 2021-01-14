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
    private Integer id;

    @Column(unique = true)
    @NonNull
    private String nom;

    @Column(unique = true)
    @NonNull
    private String adresse;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "organisateur")
    private List<Exposition> expos;

    public float CAannuel(int a) {
        float ca = 0;
        for (Exposition e : expos) {
            Date d = new Date(a, 5, 5);
            if (d.after(new Date(a, 1, 1)) && d.before(new Date(a, 12, 31))) {
                ca = e.Ca() + ca;
            }
        }
        return ca;
    }
}
