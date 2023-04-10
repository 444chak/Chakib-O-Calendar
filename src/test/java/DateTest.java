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
    @DisplayName("Test de la méthode dernierJourDuMois(int mois, int annee)")
    public void dernierJourDuMois() {
        assertAll(
                () -> assertEquals(31, Date.dernierJourDuMois(3, 2014)),
                () -> assertEquals(30, Date.dernierJourDuMois(4, 1972)),
                () -> assertEquals(29, Date.dernierJourDuMois(2, 2020)),
                () -> assertEquals(28, Date.dernierJourDuMois(2, 2021))
        );

    }

    @Test
    @DisplayName("Test de la méthode compareTo()")
    public void compareTo() {
        assertAll(
                () -> assertEquals(-1, new Date(14, 7, 2004).compareTo(new Date(14, 7, 2005))),
                () -> assertEquals(1, new Date(4, 12, 1942).compareTo(new Date(4, 12, 1935))),
                () -> assertEquals(-1, new Date(31, 3, 2012).compareTo(new Date(17, 4, 2012))),
                () -> assertEquals(1, new Date(31, 12, 1965).compareTo(new Date(2, 9, 1965))),
                () -> assertEquals(-1, new Date(14, 7, 2004).compareTo(new Date(15, 7, 2004))),
                () -> assertEquals(1, new Date(4, 12, 1942).compareTo(new Date(3, 12, 1942))),
                () -> assertEquals(0, new Date(31, 3, 2012).compareTo(new Date(31, 3, 2012)))
        );
    }


}
