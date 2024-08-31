package yo;

public class Main {
    public static void main(String[] args) {
        
    }

    public static void agregarPersona (String[][] lista, String nombre, String edad, String entrada, String invitados, String ingresado) {
        for (int i=0; i<lista.length; i++) {
            if (lista[i][0] == null) {
                lista[i][0] = nombre;
                lista[i][1] = edad;
                lista[i][2] = entrada;
                lista[i][3] = invitados;
                lista[i][4] = ingresado;
                break;
            }
        }
    }

    public static String[][] inicializarLista() {
        String[][] lista = new String[10][5];
        agregarPersona(lista, "Nawel", "20", "VIP", "5", "False");
        agregarPersona(lista, "Joaquin", "21", "VIP", "2", "True");
        agregarPersona(lista, "Berni", "10", "False", "0", "False");
        agregarPersona(lista, "Matias", "26", "False", "5", "False");
        agregarPersona(lista, "Hola", "18", "General", "2", "False");
        return lista;
    }

    public static boolean verificarEdad(String[][] lista, String nombre) {
        boolean permitido = false;
        for (int i=0; i<10; i++) {
            if (lista[i][0] != null) {
                if (lista[i][0].equals(nombre)) {
                    if (Integer.parseInt(lista[i][1]) < 18) {
                        permitido = false;
                    }
                    else {
                        permitido = true;
                    }
                }
                else {
                    System.out.println("error");
                }
            }
        }
        return permitido;
    }

    public static String verificarBoleto(String[][] lista, String nombre) {
        String boleto = "vacío";
        for (int i=0; i<10; i++) {
            if (lista[i][0].equals(nombre)) {
                boleto = lista[i][2];
                 break;
            }
            else {
                boleto = "error";
            }
        }
        return boleto;
    }

    public static String validarInvitados(String) {
        
    }
}