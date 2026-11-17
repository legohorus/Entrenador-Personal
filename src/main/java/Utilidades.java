import java.util.Scanner;

/**
 * Clase con métodos de utilidad para la entrada de datos por teclado y el manejo de días de la semana.
 */
public class Utilidades {
    private static final String[] DIAS = {
            "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"
    };
    public static String leerCadena(Scanner teclado, String s) {
        System.out.print(s);
        // Muestra un mensaje y lee una cadena (línea completa) por teclado
        return teclado.nextLine(); // @todo MODIFICAR PARA DEVOLVER LA CADENA LEÍDA
    }

    public static int leerNumero(Scanner teclado, String mensaje, int minimo, int maximo) {
        int numero = Integer.MIN_VALUE;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            String respuesta = teclado.nextLine();
            try {
                numero = Integer.parseInt(respuesta.trim());
                valido = numero >= minimo && numero <= maximo;
            } catch (NumberFormatException ex) {
                valido = false;
            }
        }
        // Muestra un mensaje y lee un número por teclado (si no es un número o está fuera de rango, vuelve a
        // solicitarlo)
        return numero; // @todo MODIFICAR PARA DEVOLVER EL NÚMERO LEÍDO
    }

    public static int leerDiaDeLaSemana(Scanner teclado, String mensaje) {
        int pos = -1;
        while (pos == -1) {
            String respuesta = leerCadena(teclado, mensaje);
            pos = diaSemanaAPosicion(respuesta);
        }
        // Muestra un mensaje, lee un día de la semana por teclado (L, M, X, J, V, S, D) y devuelve su posición
        // dentro de la semana (0-6). Si la entrada no es válida, vuelve a solicitarla
        return pos; // @todo MODIFICAR PARA DEVOLVER EL DÍA DE LA SEMANA LEÍDO
    }

    public static int diaSemanaAPosicion(String dia) {
        int resultado = -1;
        if (dia != null && dia.length() == 1){
            for (int i = 0; i < DIAS.length; i++){
                if (DIAS[i].substring(0, 1).equalsIgnoreCase(dia) ||
                        (dia.equalsIgnoreCase("X") && i == 2)){
                    resultado = i;
                    return resultado;
                }
            }
        }
        // Devuelve la posición de un día de la semana (L, M, X, J, V, S, D) dentro de la semana (0-6),
        // o -1 si no es un día válido
        return resultado; // @todo MODIFICAR PARA DEVOLVER LA POSICIÓN DEL DÍA DE LA SEMANA
    }

    public static String posicionADiaSemana(int pos) {
        String resultado = "Desconocido";
        if (pos >= 0 && pos <= 6){
            resultado = DIAS[pos];
        }
        // Devuelve el día de la semana (Lunes, Martes, Miércoles, Jueves, Viernes, Sábado, Domingo)
        // correspondiente a una posición dentro de la semana (0-6), o "Desconocido" si no es válida
        return resultado; // @todo MODIFICAR PARA DEVOLVER EL DÍA DE LA SEMANA
    }
}
