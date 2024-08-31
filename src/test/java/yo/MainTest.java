package yo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    String[][] lista = Main.inicializarLista();
    @BeforeEach
    void inicializarLista() {
        lista = Main.inicializarLista();
    }

    @Test
    void testAgregarPersona() {
        String[][] listaTest = new String[10][5];
        Main.agregarPersona(listaTest, "Test", "0", "VIP", "1", "true");

        assertEquals("Test", listaTest[0][0]);
        assertEquals("0", listaTest[0][1]);
        assertEquals("VIP", listaTest[0][2]);
        assertEquals("1", listaTest[0][3]);
        assertEquals("true", listaTest[0][4]);
    }

    @Test
    void testInicializarLista() {
        assertEquals("Nawel",lista[0][0]);
        assertEquals("Berni", lista[2][0]);
    }

    @Test
    void testVerificarEdad() {
        boolean resultado = Main.verificarEdad(lista, "Nawel");
        assertEquals(true, resultado);

        resultado = Main.verificarEdad(lista, "Berni");
        assertEquals(false, resultado);
    }

    @Test
    void testVerificarBoleto() {
        String resultado = Main.verificarBoleto(lista, "Nawel");
        assertEquals("VIP", resultado);

        resultado = Main.verificarBoleto(lista, "Berni");
        assertEquals("False", resultado);
    }
}
