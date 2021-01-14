/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package galerie.entity;
import galerie.dao.PersonneRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

/**
 *
 * @author escol
 */
@Log4j2 // Génère le 'logger' pour afficher les messages de trace
@DataJpaTest
public class PersonneTest {
  
    @Autowired
    private PersonneRepository perso;
    
    @Test
    @Sql("test-data_personne.sql")
    public void onSaitCompterLesEnregistrements() {
        log.info("On compte les enregistrements de la table 'Personne'");
        int combienDansLeJeuDeTest = 1; 
        long nombre = perso.count();
        assertEquals(combienDansLeJeuDeTest, nombre, "On doit trouver 1 personne" );
    }
}
