import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @Test
    @DisplayName("Test de la méthode estBissextile()")
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

}