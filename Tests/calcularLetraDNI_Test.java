

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class calcularLetraDNI_Test {

    /**
     * Test parametrizado para comprobar que el método calcularLetraDNI devuelve la letra correcta.
     * Se asume que el DNI es válido (cadena de 8 dígitos).
     */
    @ParameterizedTest(name = "Para DNI {0} se espera la letra {1}")
    @CsvSource({
            "00000000, T",
            "12345678, Z",
            "00000001, R",
            "00000002, W",
            "00000003, A",
            "00000004, G",
            "00000005, M",
            "00000006, Y",
            "00000007, F",
            "00000008, P",
            "00000009, D",
            "00000010, X",
            "00000011, B",
            "00000012, N",
            "00000013, J",
            "00000014, Z",
            "00000015, Q",
            "00000016, S",
            "00000017, V",
            "00000018, H",
            "00000019, L",
            "00000020, C",
            "00000021, K",
            "00000001, R"
    })
    public void testCalcularLetraDNI_Valid(String dni, char expectedLetter) {
        assertEquals(expectedLetter, Main.calcularLetraDNI(dni));
    }

    /**
     * Test para comprobar que al pasar un DNI con longitud incorrecta se lanza IllegalArgumentException.
     * Esto demuestra cómo se debería comprobar la longitud en el código.
     */
    @ParameterizedTest(name = "DNI de longitud incorrecta: {0}")
    @ValueSource(strings = {"1234567", "123456789"})
    public void testCalcularLetraDNI_InvalidLength(String dni) {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.calcularLetraDNI(dni);
        });
    }
}
