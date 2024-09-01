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
        agregarPersona(lista, "Matias", "26", "General", "5", "True");
        agregarPersona(lista, "Hola", "18", "General", "2", "True");
        return lista;
    }

    public static boolean verificarEdad(String[][] lista, String nombre) {
        boolean permitido = false;
        for (int i=0; i<10; i++) {
            if (lista[i][0] != null && lista[i][0].equals(nombre)) {
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

    public static String validarInvitados(String[][] lista, String nombre) {
        String resultado = "";
        for (int i=0; i<10; i++) {
            if (lista[i][0] != null && lista[i][0].equals(nombre)) {
                if (lista[i][2].equals("VIP")) {
                    int invitados = Integer.parseInt(lista[i][3]);
                    if (invitados > 2) {
                        resultado = "Excede máximo";
                    }
                    else resultado = "Permitido";
                } 
                else resultado = "No es VIP";
            }
        }
        return resultado;
    }

    public static int aforoDisponible(String[][] lista, int aforo) {
        int aforoDisponible = aforo;

        if (aforoDisponible == 20) {
            for (int i=0; i<10; i++) {
                if (lista[i][2] == "General" && lista[i][4] == "True") aforoDisponible--;
            }
        }
        else if (aforoDisponible == 10) {
            for (int i=0; i<10; i++) {
                if (lista[i][2] == "VIP" && lista[i][4] == "True") {
                    aforoDisponible--;
                    
                    String validarInvitados = validarInvitados(lista, lista[i][0]); 
                    if (validarInvitados == "Permitido") {
                        aforoDisponible = aforoDisponible - Integer.parseInt(lista[i][3]);
                    }
                }
            }
        }
        return aforoDisponible;
    }

    public static String[][] ingresarPersona(String[][] lista, String nombre) {
        for (int i=0; i<10; i++) {
            if (lista[i][0] != null && lista[i][0].equals(nombre)) {
                if (lista[i][4] == "False") lista[i][4] = "True";
                else System.out.println("Ya está ingresado");
            }
        }
        return lista;
    }

    public static boolean permitirEntrada(String[][] lista, int numeroFila) {
        String nombre = lista[numeroFila][0];

        boolean CHECKedad = verificarEdad(lista, nombre);
        String boleto = verificarBoleto(lista, nombre);
        String invitados = validarInvitados(lista, nombre);
        
        boolean CHECKaforo = false;
        if (boleto == "General") {
            int aforo = aforoDisponible(lista, 20);
            if (aforo > 0) CHECKaforo = true;
        }
        else if (boleto == "VIP") {
            int aforo = aforoDisponible(lista, 10);
            if (invitados == "Permitido") {
                int totalPersonas = 1+(Integer.parseInt(lista[numeroFila][3]));

                if (aforo > totalPersonas) CHECKaforo = true;
            }
        }

        if (CHECKedad && boleto != "False" && CHECKaforo) return true;
        else return false;
    }

    public static String[][] removerPersona(String[][] lista, String nombre) { 
        for (int i=0; i<10; i++) {
            if (lista[i][0] != null && lista[i][0].equals(nombre)) {
                
            }
        }
        return lista;
    }
}