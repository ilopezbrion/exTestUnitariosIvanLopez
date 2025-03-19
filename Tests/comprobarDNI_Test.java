
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class comprobarDNI_Test {

    /**
     * Test parametrizado para comprobar que el método comprobarDNI funciona correctamente
     * cuando se pasa un DNI válido.
     */
    @ParameterizedTest(name = "Para DNI {0} y letra {1} se espera {2}")
    @CsvSource({
            "00000000, T, true",
            "00000000, A, false",
            "00000001, R, true",
            "00000002, W, true",
            "00000003, A, true",
            "00000004, G, true",
            "00000005, M, true",
            "00000006, Y, true",
            "00000007, F, true",
            "00000008, P, true",
            "00000009, D, true",
            "00000010, X, true",
            "00000011, B, true",
            "00000012, N, true",
            "00000013, J, true",
            "00000014, Z, true",
            "00000015, Q, true",
            "00000016, S, true",
            "00000017, V, true",
            "00000018, H, true",
            "00000019, L, true",
            "00000020, C, true",
            "00000021, K, true",
            "12345678, Z, true",
            "12345678, A, false"
    })
    public void testComprobarDNI_Valid(String dni, char letter, boolean expected) {
        assertEquals(expected, Main.comprobarDNI(dni, letter));
    }

    /**
     * Test para comprobar que al pasar un DNI con longitud incorrecta se lanza IllegalArgumentException.
     */
    @ParameterizedTest(name = "DNI inválido (longitud incorrecta): {0}")
    @ValueSource(strings = {"1234567", "123456789"})
    public void testComprobarDNI_InvalidLength(String dni) {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.comprobarDNI(dni, 'T');
        });
    }
}
