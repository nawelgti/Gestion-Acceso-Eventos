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

    @Test
    void testValidarInvitiados() {
        String resultado = Main.validarInvitados(lista, "Nawel");
        assertEquals("Excede máximo", resultado);

        resultado = Main.validarInvitados(lista, "Joaquin");
        assertEquals("Permitido", resultado);

        resultado = Main.validarInvitados(lista, "Berni");
        assertEquals("No es VIP", resultado);
    }

    @Test
    void testAforoDisponible() {
        int aforo = Main.aforoDisponible(lista, 20); //general
        assertEquals(18, aforo);

        aforo = Main.aforoDisponible(lista, 10); //vip
        assertEquals(5, aforo);

    }

    @Test
    void testIngresarPersona() {
        lista = Main.ingresarPersona(lista, "Nawel");
        assertEquals("True", lista[0][4]);
    }

    @Test
    void testPermitirEntrada() {
        boolean permiso = Main.permitirEntrada(lista, 0);
        assertEquals(false, permiso);

        permiso = Main.permitirEntrada(lista, 1);
        assertEquals(true, permiso);
    }

    @Test
    void testRemoverPersona() {
        Main.removerPersona(lista, "Joaquin");
        assertEquals("False", lista[1][4]);
    }

    @Test
    void testAFOROS() {
        //Comprobar aforo inicial
        assertEquals(18, Main.aforoDisponible(lista, 20)); //General
        assertEquals(5, Main.aforoDisponible(lista, 10)); //VIP

        //Ingreso 1 General y 1 VIP + 2 invitados
        Main.ingresarPersona(lista, "Antonia"); //general
        assertEquals("True", lista[8][4]);
        Main.ingresarPersona(lista, "Sofi"); //vip+2
        assertEquals("True", lista[9][4]); 

        //Comprobamos nuevo aforo
        assertEquals(17, Main.aforoDisponible(lista, 20)); //General
        assertEquals(2, Main.aforoDisponible(lista, 10)); //VIP

        //Salida 1 VIP + invitado
        Main.removerPersona(lista,"Pablo");

        //Aforo
        assertEquals(4, Main.aforoDisponible(lista, 10));
    }
}
