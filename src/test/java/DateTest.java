import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @Test
    @DisplayName("Test de la méthode estBissextile(int annee)")
    public void estBissextile()
    {
        // Selon la partition d'équivalence, il y a quatre cas à tester
        assertAll(
                () -> assertTrue(Date.estBissextile(2020)),
                () -> assertFalse(Date.estBissextile(1900)),
                () -> assertTrue(Date.estBissextile(2400)),
                () -> assertFalse(Date.estBissextile(2021))
        );
    }

    @Test
    @DisplayName("Test de la méthode dernierJourDuMois()")
    public void dernierJourDuMois() {
        assertAll(
                () -> assertEquals(31, Date.dernierJourDuMois(3, 2014)),
                () -> assertEquals(30, Date.dernierJourDuMois(4, 1972)),
                () -> assertEquals(29, Date.dernierJourDuMois(2, 2020)),
                () -> assertEquals(28, Date.dernierJourDuMois(2, 2021))
        );

    }

}
